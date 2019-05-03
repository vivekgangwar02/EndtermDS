public class SelectionSort {

    public static void main(String[] args) {
        int[] n={65,25,22,12,11};

        for(int i=0;i<n.length-1;i++)
            for(int j=1+i;j<n.length;j++) {
                if(n[i]>n[j])
                {
                    int temp=n[j];
                    n[j]=n[i];
                    n[i]=temp;
                }
            }
        for(int i=0;i<n.length;i++)
            System.out.println(n[i]);
    }
}
