#include<iostream>
#include<stdio.h>
#include<string>
#include<string.h>
#include<vector>
#include<map>
using namespace std;

struct Node{
	string name, id;
};

char pathIn[105], pathOut[105], ri[10];

int main(){
	cout << "\n请输入命令  : ";
	cin >> ri >> pathIn;
	if(ri[0] != 'y' || ri[1] != 'q'){
		cout << "无效命令!\n\n" << endl;
		getchar();
		return 0;
	}

	//处理输入与输出文件的路径
	int len = strlen(pathIn);
	strcpy(pathOut, pathIn);
	for(int i = len; i >= len-4; i--) pathOut[i] = pathOut[i-1];
	len++; pathOut[len] = '\0';
	pathOut[len-5] = 't'; pathOut[len-6] = 'u'; pathOut[len-7] = 'o';
	freopen(pathIn, "r", stdin);
	freopen(pathOut, "w", stdout);

	string s;
	vector<string>vec, pro;
	map<string, vector<Node> >mp;

	while(cin >> s) vec.push_back(s);
	int cnt = vec.size();
	for(int i = 0; i < cnt; i += 3){
		if(mp[vec[i]].size() == 0) pro.push_back(vec[i]);
		mp[vec[i]].push_back({vec[i+1], vec[i+2]});
	}
	for(string i : pro){
		cout << i << endl;
		for(Node j : mp[i]){
			cout << j.name << " " << j.id << endl;
		}
		cout << endl;
	}
	system("pause");
	return 0;
}