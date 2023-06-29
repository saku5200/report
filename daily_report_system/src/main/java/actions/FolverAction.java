package actions;


import java.io.IOException;

import javax.servlet.ServletException;

import services.FollowService;

public class FolverAction extends ActionBase {

    private FollowService service; //追記

    /**
     * indexメソッドを実行する
     */
    @Override
    public void process() throws ServletException, IOException {

        service = new FollowService(); //追記

        //メソッドを実行
        invoke();

        service.close(); //追記

    }

    /**
     * 新規登録を行う
     * @throws ServletException
     * @throws IOException

    public void create() throws ServletException, IOException {

        //CSRF対策 tokenのチェック
        if (checkToken()) {



            //セッションからログイン中の従業員情報を取得
            EmployeeView ev = (EmployeeView) getSessionScope(AttributeConst.LOGIN_EMP);
            EmployeeView eev = (EmployeeView) getSessionScope(AttributeConst.EMP_ID);

            //パラメータの値をもとに日報情報のインスタンスを作成する
            FollowView fv = new FollowView(
                    null,
                    eev,
                    ev //ログインしている従業員を、日報作成者として登録する
                    );

            //情報登録
            List<String> errors = service.create(fv);

            if (errors.size() > 0) {
                //登録中にエラーがあった場合

                putRequestScope(AttributeConst.TOKEN, getTokenId()); //CSRF対策用トークン
                putRequestScope(AttributeConst.FOLLOW, fv);//入力された日報情報
                putRequestScope(AttributeConst.ERR, errors);//エラーのリスト

                //新規登録画面を再表示
                forward(ForwardConst.FW_EMP_FOLLOW);

            } else {
                //登録中にエラーがなかった場合



                //一覧画面にリダイレクト
                redirect(ForwardConst.ACT_EMP, ForwardConst.CMD_INDEX);
            }
        }
    }*/

}
