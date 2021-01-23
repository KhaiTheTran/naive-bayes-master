import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

// ************************** IMPORTANT **************************
//   !!!!!! DO NOT TOUCH OR CHANGE ANYTHING IN THIS FILE !!!!!!
//     You will not submit this file. The only file you will
//     submit is NaiveBayes.java, which is expected to be
//     run with the given version of SpamFilter.
//     If you change anything here, our grading script won't
//     work and you will lose points!
// ***************************************************************

/**
 * DO NOT CHANGE!
 * The main class to run. Usage: 
 * (Compile)    $javac SpamFilterMain.java
 * (Run)        $java SpamFilterMain
 *
 * This class handles loading the data files for you. It then uses 
 * the NaiveBayes class you implemented to train a Naive Bayes 
 * classifier, and classify test emails.
 */
public class SpamFilterMain {

    // DO NOT CHANGE!
    public static void main(String[] args) throws IOException {
        // Print current working directory path.
        // IMPORTANT: the "data/" directory is required to be in the same
        //            directory as where this file is executed. Check the 
        //            console output if you're unsure.
        String cwd = Paths.get(".").toAbsolutePath().normalize().toString();
        System.out.println("# Current working directory (CWD): " + cwd);

        File dataDir = new File("data");
        if (!dataDir.exists() || !dataDir.isDirectory()) {
            System.out.println("# Could not find the data directory. " +
                               "Make sure it is under the CWD printed above.");
            return;
        }

        File[] trainHams = null;
        File[] trainSpams = null;
        File[] tests = null;
        // Traverse the data directory to get training and testing files.
        // Note: Avoiding any sort of path hardcoding (eg forward or backward 
        //       slashes) to accommodate any OS.
        File[] subDirs = dataDir.listFiles();
        for (File dir : subDirs) {
            if (dir.getName().equals("train")) {
                File[] trainDirs = dir.listFiles();
                for (File trainDir : trainDirs) {
                    if (trainDir.getName().equals("ham")) {
                        trainHams = trainDir.listFiles();
                    } else {  // spams
                        trainSpams = trainDir.listFiles();
                    }
                }
            } else {  // test
                tests = dir.listFiles();
            }
        }

        if (sanityCheck(trainHams, trainSpams, tests)) {
            System.out.println("# Testing/training files loaded successfully.");

            NaiveBayes nb = new NaiveBayes();

            System.out.println("# Training...");
            nb.train(trainHams, trainSpams);
            System.out.println("# Done training.");

            System.out.println("# Test results:");
            nb.classify(tests);
        }
    }

    /*
     * DO NOT CHANGE
     * Perform simple sanity checks on the training/testing files loaded
     * before passing them into NaiveBayes.
     */
    public static boolean sanityCheck(File[] trainHams, File[] trainSpams, File[] tests) {
        boolean pass = true;

        if (trainHams == null || trainHams.length == 0) {
            System.out.println("# Error loading training ham files.");
            pass = false;
        }

        if (trainSpams == null || trainSpams.length == 0) {
            System.out.println("# Error loading training spam files.");
            pass = false;
        }

        if (tests == null || tests.length == 0) {
            System.out.println("# Error loading testing files.");
            pass = false;
        }

        return pass;
    }
}