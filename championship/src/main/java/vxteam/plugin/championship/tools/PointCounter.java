package vxteam.plugin.championship.tools;

import java.util.function.IntBinaryOperator;

public class PointCounter {

    private static int[] globalTeamsPoints = new int[]{0,0,0,0,0,0,0,0};
    private int[] teamsPoints =  new int[]{0,0,0,0,0,0,0,0};


    //Возвращают дубликат масива
    public static int[] getGlobalTeamsPoints() {
        return globalTeamsPoints.clone();
    }
    public int[] getTeamsPoints() {
        return teamsPoints.clone();

    }

// Функции для прибавления и вычетания былов.
// Первые 4 принемают число и команду которой нужно прибвыить,
// а оставшиеся - массив из 8 элементов которые будут пребавлины\отняты у соответствущей команды

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                                                                                                                                    //
    public static void addGlobalPoints(int count, Teams team) { globalTeamsPoints[team.ordinal()] += count; }                       //
    public void addPoints(int count, Teams team) { teamsPoints[team.ordinal()] += count; }                                          //
    public static void removeGlobalPoints(int count, Teams team) { globalTeamsPoints[team.ordinal()] -= count; }                    //
    public void removePoints(int count, Teams team) { teamsPoints[team.ordinal()] -= count; }                                       //
    public static void addGlobalPoints(int[] points) {                                                                              //
        count(points, globalTeamsPoints, (a,b) -> a + b);                                                                           //
    }                                                                                                                               //
    public void addPoints(int[] points) { count(points, teamsPoints, (a,b) -> a + b); }                                             //
    public static void removeGlobalPoints(int[] points) { count(points, globalTeamsPoints, (a,b) -> a - b); }                       //
    public void removePoints(int[] points) { count(points, teamsPoints, (a,b) -> a - b); }                                          //
                                                                                                                                    //
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//производит операцию с каждым элементом 2х масивов
    private static void count(int[] points, int[] original, IntBinaryOperator func) {
        for (int i = original.length - 1; i >= 0; i--) {
            func.applyAsInt(original[i], points[i]);
        }
    }
}
