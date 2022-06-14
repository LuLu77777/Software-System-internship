package com.mall.sounor.controller;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.mall.sounor.common.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;

@RestController
@RequestMapping("/files")
public class FileController {
    //获取端口
    @Value("${server.port}")
    private String port;

    private static final String ip = "http://localhost";
    /**
     * 上传接口
     * @param file
     * @return
     * @throws IOException
     */
    @PostMapping("/upload")
    public Result<?> upload(MultipartFile file){
        String originalFilename = file.getOriginalFilename(); //获取源文件的名称
        //定义文件的唯一标识（前缀） UUID通用唯一识别码
        String flag = IdUtil.fastSimpleUUID();
        String rootFilePath = System.getProperty("user.dir") + "/sounor/src/main/resources/files/" + flag + "_" + originalFilename; //获取上传的路径
        try {
            FileUtil.writeBytes(file.getBytes(), rootFilePath); //把文件写入到上传的路径
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Result.success(ip + ":" + port + "/files/" + flag); //返回结果url
    }

    /**
     * 下载接口
     * @param flag
     * @param response
     */
    @GetMapping("/{flag}")
    public void getFiles( @PathVariable String flag,HttpServletResponse response){
        OutputStream os; //新建一个输出流对象
        String basePath = System.getProperty("user.dir") + "/sounor/src/main/resources/files/"; //定义文件上传的根路径
        List<String> fileNames = FileUtil.listFileNames(basePath); //获取所有的文件名称
        String fileName = fileNames.stream().filter(name -> name.contains(flag)).findAny().orElse(""); //找到跟参数一致的文件
        try{
            if(StrUtil.isNotEmpty(fileName)) {
                response.addHeader("Conten-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "utf-8"));
                response.setContentType("application/octet-stream");
                //通过文件的路径读取文件字节流
                byte[] bytes = FileUtil.readBytes(basePath + fileName); //通过文件路径读取文件字节流
                //通过输出流返回文件
                os = response.getOutputStream();
                os.write(bytes);
                os.flush();
                os.close();
            }
        }catch(Exception e){
            System.out.println("文件下载失败");
        }
    }
}
