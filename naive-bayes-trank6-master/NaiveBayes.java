// Do not submit with package statements if you are using eclipse.
// Only use what is provided in the standard libraries.

import java.awt.image.SampleModel;
import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

public class NaiveBayes {

    /*
     * !! DO NOT CHANGE METHOD HEADER !!
     * If you change the method header here, our grading script won't
     * work and you will lose points!
     * 
     * Train your Naive Bayes Classifier based on the given training
     * ham and spam emails.
     *
     * Params:
     *      hams - email files labeled as 'ham'
     *      spams - email files labeled as 'spam'
     */
	static Double hamsP;
	static Double spamP;
	static Double hamsW;
	static Double spamsW;
	static Map<String, Integer> hamsM = new HashMap<>();
	static Map<String, Integer> spamsM = new HashMap<>();
    public void train(File[] hams, File[] spams) throws IOException {
    	
    	//hams emails containing w
    	int k = 0;
    	while (k <hams.length) {
    		HashSet<String> token = tokenSet(hams[k]);
    		for(String w: token) {
    			if(hamsM.get(w) != null) {
    				int countW = hamsM.get(w)+1;
    				hamsM.put(w, countW);
    			} else{hamsM.put(w, 1);}
    		}
    		k++;
    	}
    	//hams emails containing w
    	k = 0;
    	while (k <spams.length) {
    		HashSet<String> token = tokenSet(spams[k]);
    		for(String w: token) {
    			if(spamsM.get(w) != null) {
    				int countW = spamsM.get(w)+1;
    				spamsM.put(w, countW);
    			} else{spamsM.put(w, 1);}
    		}
    		k++;
    	}
    	// P(H)
    	hamsP = (hams.length * 1.0)/ (double)(hams.length + spams.length);
    	//P(S)
    	spamP = (spams.length * 1.0)/ (double)(hams.length + spams.length);
    	//P(w | S)
    	spamsW = spams.length + 2.0;
    	//P(w | H)
    	hamsW =hams.length + 2.0;
    }

    /*
     * !! DO NOT CHANGE METHOD HEADER !!
     * If you change the method header here, our grading script won't
     * work and you will lose points!
     *
     * Classify the given unlabeled set of emails. Follow the format in
     * example_output.txt and output your result to stdout. Note the order
     * of the emails in the output does NOT matter.
     * 
     * Do NOT directly process the file paths, to get the names of the
     * email files, check out File's getName() function.
     *
     * Params:
     *      emails - unlabeled email files to be classified
     */
    public void classify(File[] emails) throws IOException {
    	int k = 0;
    	double spamE = 0.0;
    	double hamsE = 0.0;
    	double hamsWH;
    	double spamWS;
    	for (File em: emails) {
    		hamsWH = 0.0;
        	spamWS = 0.0;
    		HashSet<String> emailsW = tokenSet(em);
    		for(String e: emailsW) {
    			if(hamsM.get(e) != null) {
    			hamsE = (double)hamsM.get(e) + 1.0;
    			}else {hamsE = 1.0;};
    			
    			if(spamsM.get(e) != null) {
    				spamE = (double)spamsM.get(e) + 1.0;
    			}else {spamE = 1.0;};
    			//Compute P(w | H)
        		double pWH = (hamsE)/hamsW;
        		hamsWH += Math.log(pWH);
        		// Compute P(w | S)
        		double sWS = (spamE)/spamsW;
        		spamWS += Math.log(sWS);
    		}
    		if((Math.log(hamsP) + hamsWH)> (Math.log(spamP)+ spamWS)) {
    			System.out.println(em.toString().split("/")[2]+" "+"ham");
    		}else{
    			System.out.println(em.toString().split("/")[2]+" "+"spam");
    		};
    		
    	}
    }


    /*
     *  Helper Function:
     *  This function reads in a file and returns a set of all the tokens. 
     *  It ignores "Subject:" in the subject line.
     *  
     *  If the email had the following content:
     *  
     *  Subject: Get rid of your student loans
     *  Hi there ,
     *  If you work for us , we will give you money
     *  to repay your student loans . You will be 
     *  debt free !
     *  FakePerson_22393
     *  
     *  This function would return to you
     *  ['be', 'student', 'for', 'your', 'rid', 'we', 'of', 'free', 'you', 
     *   'us', 'Hi', 'give', '!', 'repay', 'will', 'loans', 'work', 
     *   'FakePerson_22393', ',', '.', 'money', 'Get', 'there', 'to', 'If', 
     *   'debt', 'You']
     */
    public static HashSet<String> tokenSet(File filename) throws IOException {
        HashSet<String> tokens = new HashSet<String>();
        Scanner filescan = new Scanner(filename);
        filescan.next(); // Ignoring "Subject"
        while(filescan.hasNextLine() && filescan.hasNext()) {
            tokens.add(filescan.next());
        }
        filescan.close();
        return tokens;
    }
}
