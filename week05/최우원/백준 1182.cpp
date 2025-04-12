#include <bits/stdc++.h>
using namespace std;
int arr[30];
int n,s;
int cnt = 0;

void func(int cur, int tot){
    if(cur == n){ //끝까지 다 선택을 해야됨. 부분 수열이더라도 끝까지 각각의 경우를 독립사건으로 계산하기 위해선
        if(tot == s) cnt ++;
        return;
    }
    func(cur+1, tot);   // 현재 수를 선택하지 않는 경우, 한 칸은 선택의 갯수를 나타내고, 한칸은 해당수를 더할지 말지 선정
    func(cur+1, tot+arr[cur]);  // 현재 수를 선택하는 경우 
}

int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> n >> s;
    for(int i = 0; i < n; i++){
        cin >> arr[i];
    }    
    func(0,0);
    if(s == 0) cnt --; // 공집합제거 중요 !! ********
    cout << cnt;
    return 0;
}
