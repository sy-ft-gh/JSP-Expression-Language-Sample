package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.UserInput;

@WebServlet("/FormSampleServlet")
public class FormSampleServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  protected void doPost(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {

    // リクエストパラメータを取得
    // name属性をキーにgetParameterメソッドで取得します
    String name = request.getParameter("name");
    // 配列要素はgetParameterValuesメソッドで取得します
    String[] addr = request.getParameterValues("address");
    String gender = request.getParameter("gender");

    // リクエストパラメータをチェック
    String errorMsg = "";
    if (name == null || name.length() == 0) {
      errorMsg += "名前が入力されていません<br>";
    }
    // 住所を結合した文字列を宣言 
    String address ="";
    if (addr == null || addr.length == 0) {
        errorMsg += "住所が入力されていません<br>";
    }
    if (gender == null || gender.length() == 0) {
      errorMsg += "性別が選択されていません<br>";
    }
    if ("1".equals(name)) {
    	throw new IllegalArgumentException("名前に1が指定されました");
    }
    // 入力エラーが無い場合、入力された情報をインスタンスとして生成
    UserInput uInput = null;
    if (errorMsg.length() == 0) {
    	errorMsg = null;
    	uInput = new UserInput(name, addr, gender);
    } 
    // 入力内容、エラー情報をリクエストスコープ変数として格納
    request.setAttribute("uInput", uInput);
    request.setAttribute("errorMsg", errorMsg);
    
    // 設定されたフォワード先にフォワード
    RequestDispatcher dispatcher =
        request.getRequestDispatcher("/WEB-INF/jsp/formSample.jsp");
    dispatcher.forward(request, response);

  }
}