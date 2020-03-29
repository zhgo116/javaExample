package cn.fancy.suafa.bayes;

/**
 *  贝叶斯电影评分算法
 *
 *  本人在公司实现工程师总评分排名用到此算法，所以写了一个DEMO
 *  大家在用到类似算法，直接套用公式即可
 *
 * 贝叶斯平均算法公式：WR=U/(U+M)*R+(M/(U+M)*C)
 WR：该电影的最终得分；

 v：该电影的投票人数；

 m：排名TOP250电影的最低投票数；

 R：该电影的用户投票的平均得分；

 C：所有电影的平均得分。


 * 本贝叶斯平均算法：  (persons / (persons + top250) * scores) + top250 / (persons + top250) * allAvg);
 *                  persons*scores+top250*allAvg)/(persons+top250);
 *
 * @see https://baijiahao.baidu.com/s?id=1578747759353682803&wfr=spider&for=pc
 * @author caosheng
 * @date 2019/01/01
 */
public class Bayes {
    public static void main(String[] args) {
        //所有电影
        double allScore[][] = {{90, 34, 86, 13, 91, 97, 92}, {57, 53, 46, 51, 84, 56, 44, 45, 47, 53, 42, 59, 45, 59},
                {71, 82, 83, 84, 85, 36, 48, 59, 20, 29, 17, 91},
                {46, 63, 75, 33, 74, 85, 62, 82, 31, 85, 83, 94, 83, 92, 95, 91, 94, 95, 93, 93, 59, 92},
                {64, 73, 75, 33, 71, 83, 62, 85, 31, 45, 81, 14, 93, 94, 75, 75, 52, 74, 45, 81, 41, 83, 52}, {59, 95,95, 95, 95, 95},
                {65, 75, 75, 35, 75, 85, 65, 85, 35, 45, 85, 15, 95, 95, 75, 75, 55, 75, 45, 85, 45, 85, 55}, {57, 91, 92, 91, 91, 91, 93},
                {65, 75, 75, 35, 75, 85, 65, 85, 35, 45, 85, 15, 95, 95, 75, 75, 55, 75, 45, 85, 45, 85, 55, 15, 35, 55, 75}};

        //所有电影平均分
        int acc = 0;
        //最低投票
        double top250 = allScore[0].length;
        for (double a[] : allScore) {
            double ac = 0;
            for (double aa : a) {
                ac += aa;
            }
            //取最小长度
            if (top250 > a.length) {
                top250 = a.length;
            }
            acc += ac / a.length;
        }
        double allAvg = acc / allScore.length;
        //
        double score[] = allScore[7];
        //投票人数
        double persons = score.length;
        double s = 0;
        for (double ss : score) {
            s += ss;
        }
        //该电影平均分
        double scores = s / score.length;
        System.out.println(((persons / (persons + top250) * scores) + top250 / (persons + top250) * allAvg));
        System.out.println((persons * scores + top250 * allAvg) / (persons + top250));
        System.out.println("我是master");
    }
}
