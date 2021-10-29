//! Q1 To show all the lowe and uppercase permutations

#include <bits/stdc++.h>
using namespace std;

void solve(string ip, string op)
{
    if (ip.length() == 0)
    {
        cout << op << endl;
        return;
    }
    string ch1, ch2;
    ch1 = ch2 = op;
    ch1.push_back(ip[0]);
    ch2.push_back(toupper(ip[0]));
    ip.erase(ip.begin() + 0);
    solve(ip, ch1);
    solve(ip, ch2);
}

int main()
{
    string input = "ab";
    string output = "";
    solve(input, output);
}