package actions.views;

import java.util.ArrayList;
import java.util.List;

import models.Follow;
/**
 * 日報データのDTOモデル⇔Viewモデルの変換を行うクラス
 *
 */
public class FollowConverter {
    /**
     * ViewモデルのインスタンスからDTOモデルのインスタンスを作成する
     */
    public static Follow toModel(FollowView fv) {
        return new Follow(
                fv.getId(),
                EmployeeConverter.toModel(fv.getFollowee()),
                EmployeeConverter.toModel(fv.getFollower())
                );

    }
    /**
     * DTOモデルのインスタンスからViewモデルのインスタンスを作成する
     */
    public static FollowView toView(Follow f) {

        if (f == null) {
            return null;
        }

        return new FollowView(
                f.getId(),
                EmployeeConverter.toView(f.getFollower()),
                EmployeeConverter.toView(f.getFollowee())
                );
    }
    /**
     * DTOモデルのリストからViewモデルのリストを作成する
     * @param list DTOモデルのリスト
     * @return Viewモデルのリスト
     */
    public static List<FollowView> toViewList(List<Follow> list) {
        List<FollowView> evs = new ArrayList<>();

        for (Follow f : list) {
            evs.add(toView(f));
        }

        return evs;
    }
    /**
     * Viewモデルの全フィールドの内容をDTOモデルのフィールドにコピーする
     * @param f DTOモデル(コピー先)
     * @param fv Viewモデル(コピー元)
     */
    public static void copyViewToModel(Follow f, FollowView fv) {
        f.setId(fv.getId());
        f.setFollowee(EmployeeConverter.toModel(fv.getFollower()));
        f.setFollower(EmployeeConverter.toModel(fv
                .getFollowee()));
    }
    /**
     * DTOモデルの全フィールドの内容をViewモデルのフィールドにコピーする
     * @param f DTOモデル(コピー元)
     * @param fv Viewモデル(コピー先)
     */
    public static void copyModelToView(Follow f, FollowView fv) {
        fv.setId(f.getId());
        fv.setFollowee(EmployeeConverter.toView(f.getFollowee()));
        fv.setFollower(EmployeeConverter.toView(f.getFollower()));
    }






}
