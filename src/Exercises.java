import java.util.ArrayList;

public class Exercises {

    public int findMe(int[] list, int target) {
        if (list == null || list.length == 0) {return -1;}
    
        for (int i = 0; i < list.length; i++) {
            if (list[i] == target) {return i;}
        }

        return -1;
    }

    public int findMe(ArrayList<String> list, String target) {
        if (list == null || list.size() == 0) {return -1;}

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(target)) {return i;}
        }

        return -1;
    }

    public int findMeFaster(ArrayList<Integer> list, int target) {
        if (list == null || list.size() == 0) {return -1;}
    
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

        for (int i = 0; i < list.length; i++) {
            int minOrMax = list[i];
            int index = i;
            for (int j = i; j < list.length; j++) {
                if ((ascending && minOrMax > list[j]) || (!ascending && minOrMax < list[j])) {
                    minOrMax = list[j];
                    index = j;
                }
            }

            int temp = list[i];
            list[i] = list[index];
            list[index] = temp;
        }

        return list;
    }

    public ArrayList<String> selection(ArrayList<String> list, boolean ascending) {
        if (list == null || list.size() == 0) {return null;}

        for (int i = 0; i < list.size(); i++) {
            String minOrMax = list.get(i);
            int index = i;
            for (int j = i; j < list.size(); j++) {
                if ((ascending && minOrMax.compareTo(list.get(j)) > 0) || (!ascending && minOrMax.compareTo(list.get(j)) < 0)) {
                    minOrMax = list.get(j);
                    index = j;
                }
            }

            String temp = list.get(i);
            list.set(i, list.get(index));
            list.set(index, temp);
        }

        return list;
    }

    public ArrayList<Integer> merge(ArrayList<Integer> list, boolean ascending) {
        if (list == null || list.size() == 0) {return null;}

        if (list.size() > 1) {
            ArrayList<Integer> list1 = new ArrayList<Integer>();
            for (int i = 0; i < list.size() / 2; i++) {
                list1.add(list.get(i));
            }

            ArrayList<Integer> list2 = new ArrayList<Integer>();
            for (int i = list.size() / 2; i < list.size(); i++) {
                list2.add(list.get(i));
            }

            
            list1 = merge(list1, ascending);
            list2 = merge(list2, ascending);

            for (int i = 0; i < list.size(); i++) {
                if (ascending) {
                    if (list1.size() == 0) {
                        list.set(i, list2.get(0));
                        list2.remove(0);
                    } else if (list2.size() == 0 || list1.get(0) < list2.get(0)) {
                        list.set(i, list1.get(0));
                        list1.remove(0);
                    } else {
                        list.set(i, list2.get(0));
                        list2.remove(0);
                    }
                } else if (!ascending) {
                    if (list1.size() == 0) {
                        list.set(i, list2.get(0));
                        list2.remove(0);
                    } else if (list2.size() == 0 || list1.get(0) > list2.get(0)) {
                        list.set(i, list1.get(0));
                        list1.remove(0);
                    } else {
                        list.set(i, list2.get(0));
                        list2.remove(0);
                    }
                }
            }
        }
        

        return list;
    }

    public String[] merge(String[] list, boolean ascending) {
        if (list == null || list.length == 0) {return null;}

        if (list.length > 1) {
            String[] list1 = new String[(int) list.length / 2];
            for (int i = 0; i < list1.length; i++) {
                list1[i] = list[i];
            }

            String[] list2 = new String[((int) list.length / 2) + list.length % 2];
            for (int i = list2.length - 1; i < list.length; i++) {
                list2[(int) (i - list2.length)] = list[i];
            }

            
            list1 = merge(list1, ascending);
            list2 = merge(list2, ascending);

            for (int i = 0; i < list.length; i++) {
                if (ascending) {
                    if (list1.length == 0) {
                        list[i] = list2[0];
                        list2.remove(0);
                    } else if (list2.length == 0 || list1[0].compareTo(list2[0]) < 0) {
                        list[i] = list1[0];
                        list1.remove(0);
                    } else {
                        list[i] = list2[0];
                        list2.remove(0);
                    }
                } else if (!ascending) {
                    if (list1.length == 0) {
                        list[i] = list2[0];
                        list2.remove(0);
                    } else if (list2.length == 0 || list1[0].compareTo(list2[0]) > 0) {
                        list[i] = list1[0];
                        list1.remove(0);
                    } else {
                        list[i] = list2[0];
                        list2.remove(0);
                    }
                }
            }
        }
        

        return list;
    }
}