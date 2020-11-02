#include<stdio.h>
#include<stdlib.h>


struct Stack{
	int top;
	int *array;
	int capacity;
};
Stack* initialize(){
	struct Stack *s=(struct Stack*)malloc(sizeof(struct Stack));
	s->top=-1;
	s->capacity=10;
	s->array=(int*)malloc(s->capacity * sizeof(int));
	return s;
}

int isfull(struct Stack *s){
	
		return s->top==s->capacity-1 ;		
	
}
int isempty(struct Stack *s){
	
		return s->top==-1;		
	
}

int insert(struct Stack *s){
	int n;
	if(isfull(s)){
		printf("stack full");
	}else{
		printf("enter elemnet");
		scanf("%d",&n);
		s->top++;
		s->array[s->top]=n;
	}
}
int pop(struct Stack *s){
	printf(" pop element is: %d",s->array[s->top]);
}
int main(){
	Stack *s=initialize();
	insert(s);
	pop(s);
}

