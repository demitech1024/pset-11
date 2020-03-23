import java.util.ArrayList;

public class Exercises {

    public int findMe(int[] list, int target) {
    
    for (int i = 0; i < list.length; i++) {
        if (list[i] == target) {return i;}
    }

        return -1;
    }

    public int findMe(ArrayList<String> list, String target) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(target)) {return i;}
        }

        return -1;
    }

    public int findMeFaster(ArrayList<Integer> list, int target) {
        if (list == null) {
            return -1;
        }
    
        int start = 0;
        int end = list.size() - 1;
        int middle = 0;
        while (start <= end) {
            middle = (start + end) / 2;
            if (list.get(middle) > target) {
                end = middle - 1;
            } else if (list.get(middle) < target) {
                start = middle + 1;
            } else {
                return middle;
            }
        }

    return -1;
  }

    public int findMeFaster(String[] list, String target) {
        if (list.length == 0 || list == null) {return -1;}

        int start =0;
        int end = list.length - 1;
        int middle = 0;
        while (start <= end) {
            middle = (start + end) / 2;
            middle = ((start + end) / 2);
            if (list[middle].compareTo(target) < 0) {
                start = middle + 1;
            } else if (list[middle].compareTo(target) > 0) {
                end = middle - 1;
            } else {
                return middle;
            }
        }

        return -1;
    }

    public int[] bubble(int[] list, boolean ascending) {
        if (list == null || list.length == 0) {return null;}
        boolean sorted = false;

        while (!sorted) {
            sorted = true;

            for (int i = 0; i < list.length - 1; i++) {
                if (list[i] > list [i+1] && ascending == true) {
                    int temp = list[i];
                    list[i] = list[i+1];
                    list[i+1] = temp;

                    sorted = false;
                } else if (list[i] < list[i+1] && ascending == false) {
                    int temp = list[i];
                    list[i] = list[i+1];
                    list[i+1] = temp;

                    sorted = false;
                }
            }
        }
        
        return list;
    }

    public ArrayList<String> bubble(ArrayList<String> list, boolean ascending) {
        if (list == null || list.size() == 0) {return null;}
        boolean sorted = false;

        while (!sorted) {
            sorted = true;
            for (int i = 0; i < list.size() - 1; i++) {
                if (list.get(i).compareTo(list.get(i+1)) > 0 && ascending == true) {
                    String temp = list.get(i);
                    list.set(i, list.get(i+1));
                    list.set(i+1, temp);

                    sorted = false;
                } else if (list.get(i).compareTo(list.get(i+1)) < 0 && ascending == false) {
                    String temp = list.get(i);
                    list.set(i, list.get(i+1));
                    list.set(i+1, temp);

                    sorted = false;
                }
            }
        }

        return list;
    }

    public ArrayList<Integer> insertion(ArrayList<Integer> list, boolean ascending) {
        if (list == null || list.size() == 0) {return null;}
        
        for (int i = 1; i < list.size(); i++) {
            int m = i;
            for (int j = i - 1; j >= 0; j--) {
                if (ascending == true && list.get(m) < list.get(j)) {
                    int temp = list.get(m);
                    list.set(m, list.get(j));
                    list.set(j, temp);
                } else if (ascending == false && list.get(m) > list.get(j)) {
                    int temp = list.get(m);
                    list.set(m, list.get(j));
                    list.set(j, temp);
                } else {break;}
                m--;
            }
        }

        return list;
    }

    public String[] insertion(String[] list, boolean ascending) {
        if (list == null || list.length == 0) {return null;}

        for (int i = 1;  i < list.length; i++) {
            int m = i;
            for (int j = i - 1; j >= 0; j--) {
                if (ascending == true && list[m].compareTo(list[j]) < 0) {
                    String temp = list[m];
                    list[m] = list[j];
                    list[j] = temp;
                } else if (ascending == false && list[m].compareTo(list[j]) > 0) {
                    String temp = list[m];
                    list[m] = list[j];
                    list[j] = temp;
                } else {break;}
                m--;
            }
        }

        return list;
    }

    public int[] selection(int[] list, boolean ascending) {
        if (list == null || list.length == 0) {return null;}

        for (int i = 0; i < list.length - 1; i++) {
            int minOrMax = list[i];
            int minMaxIndex = i;
            for (int j = i; j < list.length; j++) {
                if (ascending) {
                    minOrMax = (minOrMax > list[j]) ? list[j] : minOrMax;
                    minMaxIndex = j;
                } else if (!ascending) {
                    minOrMax = (minOrMax < list[j]) ? list[j] : minOrMax;
                    minMaxIndex = j;
                }
            }

            int[] temp = new int[list.length];
            temp[i] = minOrMax;
            for (int j = 0, tempIndex = 0; j < list.length; j++, tempIndex++) {
                if (j != i && j != minMaxIndex) {
                    temp[tempIndex] = list[j];
                } else if (j == minMaxIndex && j != list.length - 1) {
                    j++;
                    temp[tempIndex] = list[j];
                } else if (j == i && tempIndex != list.length - 1) {
                    tempIndex++;
                    temp[tempIndex] = list[j];
                }
                
            }

            list = temp;
        }

        return list;
    }

    public ArrayList<String> selection(ArrayList<String> list, boolean ascending) {
        return null;
    }

    public ArrayList<Integer> merge(ArrayList<Integer> list, boolean ascending) {
        return null;
    }

    public String[] merge(String[] list, boolean ascending) {
        return null;
    }
}