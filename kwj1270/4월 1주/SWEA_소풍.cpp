#include <iostream>

using namespace std;


int main(){
    
    int test;
    cin >> test;
    for(int t=1; t <= test; t++){
        int n, k, m; 
        cin  >> n >> k >> m;
        int ans =0;
        for(int i=1; i <= n; i++){
        m -= k;
        while(m < 0) m += n-i+1;
        if(m == 0){
            ans = i;
            break;
        }
    }
    cout << "#"<< t << " "<<ans << "\n";
    }
    

    
    return 0;
}
