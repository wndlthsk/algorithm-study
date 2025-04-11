#include<bits/stdc++.h>
using namespace std;
unordered_map<int,string> num_ans; //번호로 물을 때 알파벳 대답
unordered_map<string,int> str_ans; //이름으로 불을 때 숫자 대답
int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);
    int N,M;
    cin>>N>>M;
    int num =1;
    //도감 갱신-1번 포켓몬 부터 주어짐
    while(N--)
    {
        string name;
        cin>>name;
        num_ans[num]=name;
        str_ans[name]=num;

        num++;
    }
    while(M--)
    {
        string question;
        cin>>question;
        //입력이 이름(알파벳)이면 str_ans에서 답찾고 아니면 num_ans에서 답찾기
        if(str_ans.find(question)!=str_ans.end()) cout<<str_ans[question]<<'\n';
        else cout<<num_ans[stoi(question)]<<'\n';
    }
    return 0;

}
/*
    번호-포켓몬 이름
    도감에 1~N번
    맞춰야하는 문제 M개 제시
    문제가 알파벳으로 나오면 번호 ,번호로 나오면 이름
    (VALUE로 KEY를 알아내는 방법이 필요하겠네)
    출력-M개의 줄의 정답 출력
*/
