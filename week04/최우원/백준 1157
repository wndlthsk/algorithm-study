#include <bits/stdc++.h>
using namespace std;

int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);

    int arr[26];
    string s;

    map<char,int> freq; // map(key,value), 빈도세기용 문자하나를 받아서 숫자로 늘리겠다.
    
    for(char &c : s){   // &로 인해 원본 문자도 수정 가능
        c = toupper(c); // c는 s의 주소값을 가지고 있으니 원본을 소문자로 바꿈
        freq[c]++;  // map<char .. 로 시작했으니까 c가 string 이어도 문자단위로 늘어남
    }

    int max_freq = 0;
    char result ='?';
    for(auto p : freq){
        if(p.second > max_freq){
        max_freq = p.second;    // map 형태에서 처음은 key value는 second
        result = p.first;   
    }   else if(p.second == max_freq){
        result = '?';
    }
}
    return 0;	
}   
// toupper()은 문자 하나만 대문자로 바꿔줌 그래서 순회하면서
/* 
int x = 10;
int y = 20;

// 포인터
int* p = &x;  // x의 주소를 가리킴
*p = 15;      // x가 15로 바뀜
p = &y;       // 이제 y를 가리킴

// 참조
int& r = x;   // x를 참조 (r은 x의 또다른 이름)
r = 25;       // x가 25로 바뀜
// r = y;     ❌ r이 y를 참조하게 되지 않음 (그냥 x = y 의미임)
*/
