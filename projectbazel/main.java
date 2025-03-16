import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main{
    public static void main (String[] args){
        try {
            
            ProcessBuilder processBuilder = new ProcessBuilder("bazel", "run", "//:script");
            processBuilder.redirectErrorStream(true);

            Process process = processBuilder.start();

            
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            int exitCode = process.waitFor();
            System.out.println("Exited with code: " + exitCode);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}