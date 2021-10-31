//! Q1 To show substring and remove all the duplicates

#include <bits/stdc++.h>
#include <string>

using namespace std;

void solve(string ip, string op, map<string, int> &m)
{
    if (ip.length() == 0)
    {
        m[op]++;
        if (m[op] == 1)
            cout << op << endl;
        return;
    }
    string op1 = op;
    string op2 = op;
    op2.push_back(ip[0]);
    ip.erase(ip.begin() + 0);
    solve(ip, op1, m);
    solve(ip, op2, m);
    return;
}
int main()
{
    string ip = "AAB";
    string op = "";
    map<string, int> m;
    solve(ip, op, m);
}