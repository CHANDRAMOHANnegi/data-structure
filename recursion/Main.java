
import java.util.*;

class Main {

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void solve(int[] arr) {

		if (arr.length > 1) {
			for (int i = arr.length - 2; i >= 0; i--) {
				if (arr[i] < arr[i + 1]) {
					Arrays.sort(arr, i + 1, arr.length);
					for (int j = i + 1; j < arr.length; j++) {
						if (arr[i] < arr[j]) {
							swap(arr, i, j);
							for (int x : arr) {
								System.out.print(x);
							}
							return;
						}
					}

				} else if (i == 0) {
					System.out.print(-1);
					return;
				}
			}
		} else {
			System.out.print(-1);
			return;
		}

	}

	public static void main(String[] args) throws java.lang.Exception {

		Scanner sc = new Scanner(System.in);
		int noOfTestCases = sc.nextInt();
		for (int j = 0; j < noOfTestCases; j++) {
			int noOfDigits = sc.nextInt();
			int arr[] = new int[noOfDigits];
			for (int k = 0; k < noOfDigits; k++) {
				arr[k] = sc.nextInt();
			}
			solve(arr);
			sc.nextLine();
		}
		sc.close();
	}

}
//
//
//#include <iostream>
//#include <vector>
//#include <algorithm>
//using namespace std;
//
//void
//solve (vector < int >&arr)
//{
//	if(arr.size()>1){
//   for (int i =  arr.size () - 2; i >= 0; i--)
//    {
//    	
// if (arr[i] < arr[i + 1])
//   {
//         sort(arr.begin()+i+1, arr.end());
//       for (int l = i + 1; l < arr.size(); l++)
//{
// if (arr[i] < arr[l])
//   {
//     swap (arr[i], arr[l]);
//   for (int x=0;x<arr.size();x++)
//{
// cout<<arr[x];
//}
//cout<<endl;
//     return;
//   }
//   }
//
//}
//else if (i == 0)
//{
// cout << -1<<endl;
//  return;
//}
//}
//
//
//
//    }else{
// cout << -1<<endl;
//  return;
//}
//    
//    
//    
//}
//
//
//
//int
//main (int args, char **argv)
//{
//  int t;
//  cin >> t;
//  while (t-- > 0)
//    {
//      int n;
//      cin >> n;
//      vector < int >arr (n);
//      for (int i = 0; i < n; i++)
//{
// cin >> arr[i];
//}
//      solve (arr);
//    }
//  return 0;
//}