#include <string>
#include <iostream>
#include <vector>
#include <cassert>

const int MAXARGS = 16;

int main(int argc, char *argv[]) {
  assert(argc <= MAXARGS);
  std::vector<std::string> args(MAXARGS);
  for (int i = 0; i < argc; ++i) {
    std::string s(argv[i]);
    args[i] = s;
  }

  for (int i = 0; i < argc - 1; ++i) {
    if (args[i] == args[i+1]){
      std::cout << "check" << std::endl;
    }
    else if(args[i] == "Hey!"){
      std::cout << "Huh?" << std::endl;
    }
    else {
      std::cout << "Oops!" << std::endl;
    }
  }
  return 0;
}
