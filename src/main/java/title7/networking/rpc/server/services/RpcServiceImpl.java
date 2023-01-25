package title7.networking.rpc.server.services;

import title7.networking.util.UtilFunctions;

public class RpcServiceImpl implements RpcService {

  @Override
  public String sum(String firstNumber, String secondNumber) {
     return UtilFunctions.sum(firstNumber, secondNumber);
  }

  @Override
  public String upperCaseConverter(String typedString) {
     return UtilFunctions.upperCaseConverter(typedString);
  }
}