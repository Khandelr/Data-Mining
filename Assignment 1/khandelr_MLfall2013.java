package Assignment;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class khandelr_MLfall2013 {
	
    public static int[] findFunction(int x0,int y0,int slope[],int x[],int y[],int z[],int k){
    	int error_count[]=new int[8];
    	double slope_line;
    	double b_check,b=0;
    	for(int i=0;i<slope.length;i++){
    		slope_line= Math.round(Math.tan(Math.toRadians(slope[i])));
    		if(slope_line>1 || slope_line<-1){
    			slope_line=0;
    		}
    		System.out.println("Slope of the line "+slope[i]+" :"+slope_line);
    		b=y0-x0*slope_line;
    		for(int j=0;j<k; j++){
    			b_check=y[j]-x[j]*slope_line;
    			if((b_check>b && z[j]==0) ||(b_check<b&& z[j]==1)||(b_check==b&&z[j]==0)){
    				++error_count[i];
    			}
    		}
    	
        }
    	return error_count;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        	int k;
        	final int MIN_VALUE =5;
        	Random random = new Random();
        	k= MIN_VALUE + random.nextInt(11) ;
        	int x[] = new int[15];
        	int y[] = new int[15];
        	int z[] = new int[15];
        	for(int i=0; i<k; i++){
        		x[i]= random.nextInt(100);
        		y[i]= random.nextInt(100);
        		z[i]= random.nextInt(2);
        	}
        	int x0= random.nextInt(100);
        	int y0= random.nextInt(100);
        	int slope[]= {0,45,90,135,180,225,270,315};
        	int error_count[]=new int[8];
        	int error_count_sub[][]=new int[8][8];
        	double b_check,b=0;
        	double slope_line;
        	float min_error_count,min_error_count_sub;
        	int min_error=0,min_error_sub=0;
        	int counter=0;
        	int x_error[]= new int[8],y_error[]=new int[8],z_error[]=new int[8];
        	int slope_error[]={0,30,60,90,120,150,180};
        	float temp=0;
			float threshold_of_error=0.3f;
        	System.out.println("value of k :"+k);
        	
        	error_count=findFunction(x0,y0,slope,x,y,z,k);
        	min_error_count=error_count[0];
        	
        	for(int i=0;i<slope.length;i++){
            	System.out.println("error count :"+error_count[i]);
            	if(min_error_count>error_count[i]){
            		min_error_count=error_count[i];
            		min_error=i;
            	}
            }
        	
        	slope_line=Math.round(Math.tan(Math.toRadians(slope[min_error])));
        	System.out.println("best slope :"+slope_line);
        	b=y0-x0*slope_line;
        	for(int j=0;j<k; j++){
    			b_check=y[j]-x[j]*slope_line;
    			if((b_check>b && z[j]==0) ||(b_check<b&& z[j]==1)||(b_check==b&&z[j]==0)){
    				x_error[counter]=x[j];
    				y_error[counter]=y[j];
    				z_error[counter++]=z[j];
    			}
    		}
    		
        	for(int i=0;i<counter;i++){
        		error_count_sub[i]=findFunction(x_error[i],y_error[i],slope_error,x,y,z,k);
            }
            
            System.out.println("xo :"+x0);
            System.out.println("y0 :"+y0);
            for(int i=0 ;i<k;i++){
            	System.out.print("x :"+x[i]);
            	System.out.print("\ty :"+y[i]);
            	System.out.println("\tz :"+z[i]);
            }
            for(int i=0;i<counter;i++){
            	System.out.print("x error :"+x_error[i]);
            	System.out.print("\ty error :"+y_error[i]);
            	System.out.println("\tz error :"+z_error[i]);
            
            }
            for(int i=0;i<counter;i++){
            	System.out.print("error count sub "+i+" :");
            	for(int j=0;j<slope_error.length;j++){
            		System.out.print("\t"+error_count_sub[i][j]);
            	}
            	System.out.println();
            }
            
            System.out.println("min error :"+min_error);
            System.out.println("min error count :"+min_error_count);
            
            try {
            	 
            	PrintWriter writer=new PrintWriter(new FileWriter("C:\\Users\\Ramakant Khandel\\Desktop\\khandelr_MLfall2013.tex"));
			    writer.println("\\documentclass{article}");
    			writer.println("\\usepackage{amsfonts}"
    					+ "\\topmargin 0pt"
    					+ "\\advance \\topmargin by -\\headheight"
    					+ "\\advance \\topmargin by -\\headsep"
    					+ "\\textheight 8.9in"
    					+ "\\oddsidemargin 0pt"
    					+ "\\evensidemargin \\oddsidemargin"
    					+ "\\marginparwidth 0.5in"
    					+ "\\textwidth 6.5in");
    			writer.println("\\title{ CSCI-B 565 DATA MINING\\\\");
    			writer.println("Homework 1\\\\");
    			writer.println("Morning class\\\\");
    			writer.println("Computer Science Core \\\\ Fall 2013 \\\\ Indiana University}");
    			writer.println("\\author{ Ramakant Khandel \\\\ khandelr@indiana.edu\\\\}");
    			writer.println("\\date {September 5, 2013}");
    			writer.println("\\begin{document}\\maketitle");
    			
    			writer.println("\\begin{center}");
    			writer.println("All the work herein is solely mine\n\\\\");
    			
    			writer.println("\\begin{tabular}{|c|}");
    			writer.println("\\hline");
    			writer.println("$\\Delta$ \\\\");
    			writer.println("\\hline");
    			writer.println("\\end{tabular}");
    			writer.println("\\\\");
    			writer.println("\\begin{tabular}{c|c}");
    			writer.println("\\hline");
    			writer.println("$\\delta$ & l \\\\");
    			writer.println("\\hline");
    			for(int i=0;i<k;i++){
                	writer.println("("+x[i]+","+y[i]+") &"+ z[i]+"\\\\");
                }
    			writer.println("\\hline");
    			
    			writer.println("\\end{tabular}");
    			writer.println("\\\\");
    			writer.println("\\begin{tabular}{|l r|}");
    			writer.println("\\hline");
    			writer.println("f & Correctness \\\\");
    			writer.println("\\hline");
    			writer.println("f0"+"&"+((k-min_error_count)/k)+"\\\\");
    			for(int i=0;i<counter;i++){
    				temp=error_count_sub[i][0];
    				for(int j=0;j<slope_error.length;j++){
    					if(temp>error_count_sub[i][j]){
    						temp=error_count_sub[i][j];
    					}
    				}
    				writer.println("f"+(i+1)+"&"+((k-temp)/k)+"\\\\");
    				System.out.println((i+1)+"\t"+(k-temp)/k);
    			}
    			writer.println("\\hline");
    			
    			writer.println("\\end{tabular}");
    			writer.println("\\end{center}");
    			writer.println("\\end{document}");
    			writer.close();

     			System.out.println("Done");
     
    		} catch (IOException e) {
    			e.printStackTrace();
    		}
		
	}
}
