#include<stdio.h>
#include<stdlib.h>
 struct node{
	int data;
	struct node *next;
	
};

void atbeg(){
	
}
void insert(){
	
	
	int n;
	int k=4;
	struct node *start=NULL;
	node *newnode=(node*)malloc(sizeof(node));
	node *temp;
	while(k>0){
	
	printf("Enter data to insert: ");
	scanf("%d",&n);
	newnode->data=n;
	newnode->next=NULL;
	
	if(start==NULL){
	
		start=newnode;
		 
		 start->next=NULL;
		 temp=start;
		
	}
	else{
		temp=temp->next;
	   //temp->next=newnode;
		temp=newnode;
		temp->next=NULL;
	
		
		
}
		
	k--;
}
if(start==NULL){
	printf("empty");
}
else
for(temp=start;temp!=NULL;temp=(temp->next)){
	printf("%d",temp->data);
}
}
	

int main(){
	
	insert();
}
