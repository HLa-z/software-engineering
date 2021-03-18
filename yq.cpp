#include<iostream>
#include<fstream>
#include<stdio.h>
#include<string>
#include<string.h>
#include<vector>
#include<map>
using namespace std;

struct Node{
	string name, id;
};

int main(int argc, char* argv[]){
	if(argc < 3){
		cout << "�������ļ���" << endl;
		return 0;
	}
	//�򿪶����ļ�
	ifstream infile;
	infile.open(argv[1]);
	if(!infile){
		cout << "���ļ�ʧ��" << endl;
		return 0;
	}

	//������ļ�
	ofstream outfile;
	outfile.open(argv[2]);
	if(!outfile){
		cout << "���ļ�ʧ��" << endl;
		return 0;
	}

	//�����ļ�����
	string s;
	vector<string>vec, pro;
	while(infile >> s){
		vec.push_back(s);
	}

	//ʵ�ַ���
	map<string, vector<Node> >mp;
	int cnt = vec.size();
	for(int i = 0; i < cnt; i += 3){
		if(mp[vec[i]].size() == 0) pro.push_back(vec[i]);
		mp[vec[i]].push_back({vec[i+1], vec[i+2]});
	}

	//������ļ�
	if(argc == 4){ //���������4����������ʡ�ݣ���ֻ�����ʡ�ݵĳ���
		string t;
		int len = strlen(argv[3]);
		for(int i = 0; i < len; i++) t.push_back(argv[3][i]);
		outfile << t << endl;
		for(Node i : mp[t]) outfile << i.name << " " << i.id << endl;
	}
	else{ //����ȫ�����
		for(string i : pro){
			outfile << i << endl;
			for(Node j : mp[i]){
				outfile << j.name << " " << j.id << endl;
			}
			outfile << endl;
		}
	}
	infile.close();
	outfile.close();
	cout << "�����ɹ���" << endl;
	return 0;
}
