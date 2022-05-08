//张景源+202012900344 
#include<stdio.h>
#define N 8 
double ave;
struct stu{
	int num;
	float score;
};
//三个自定义函数
void ScaStu(stu st[]) {
	for(int i = 0;i < N;i++){
		scanf("%d %f",&st[i].num,&st[i].score);
	}
}
float AveStu(stu st[]){
	double sum=0;
	for(int i = 0;i < N;i++){
		sum=sum+st[i].score;
		
	}
	printf("Ave is %f\n",sum/N);
	return(sum/N);
}
int PriStu(stu st[]){
	for(int i = 0;i < N;i++){
		if(st[i].score>ave){
			printf("%d %f\n",st[i].num,st[i].score);
		}
	}
	return 0;
}

	int main()
	{
		stu st[N];
		ScaStu(st);
		ave=AveStu(st);
		PriStu(st);
		return 0;
		
	}
