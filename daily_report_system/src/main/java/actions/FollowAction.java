package actions;

import java.io.IOException;

import javax.servlet.ServletException;

import actions.views.EmployeeView; //追記
import actions.views.FollowView;
import constants.AttributeConst;
import constants.ForwardConst;
import services.ReportService;


public class FollowAction extends ActionBase{
    private ReportService service;

    /**
     * メソッドを実行する
     */
    @Override
    public void process() throws ServletException, IOException {

        service = new ReportService();

        //メソッドを実行
        invoke();
        service.close();
    }

    /**
     * 一覧画面を表示する
     * @throws ServletException
     * @throws IOException
     */
    public void index() throws ServletException, IOException {

        EmployeeView loginEmployee = (EmployeeView) getSessionScope(AttributeConst.LOGIN_EMP);

        FollowView follower =  getSessionScope(AttributeConst.FOL_FOLOWER);
        FollowView followee = getSessionScope(AttributeConst.FOL_FOLLOWEE);


//調整中
/**
        //指定されたページ数の一覧画面に表示する日報データを取得
        int page = getPage();
        List<ReportView> reports = service.getfolPerPage(follower,followee, page);
      //ログイン中の従業員が作成した日報データの件数を取得
        long myReportsCount = service.countAllfollow(followee);

        putRequestScope(AttributeConst.REPORTS, reports); //取得した日報データ
        putRequestScope(AttributeConst.FOL_COUNT, myReportsCount); //全ての日報データの件数
        putRequestScope(AttributeConst.PAGE, page); //ページ数
        putRequestScope(AttributeConst.MAX_ROW, JpaConst.ROW_PER_PAGE); //1ページに表示するレコードの数

        //セッションにフラッシュメッセージが設定されている場合はリクエストスコープに移し替え、セッションからは削除する
        String flush = getSessionScope(AttributeConst.FLUSH);
        if (flush != null) {
            putRequestScope(AttributeConst.FLUSH, flush);
            removeSessionScope(AttributeConst.FLUSH);
        }
*/
        //一覧画面を表示
        forward(ForwardConst.FW_FOL_INDEX);
    }










}