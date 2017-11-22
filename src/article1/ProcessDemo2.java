package article1.processAPI;

import java.time.Duration;
import java.time.Instant;

public class ProcessDemo2 {

    public static void main(String[] args) {
        ProcessHandle.allProcesses()
                .filter(ph -> ph.info().command().isPresent())
                .limit(10)
                .forEach((process) -> dumpProcessInfo(process));
    }

    static void dumpProcessInfo(ProcessHandle ph) {
        System.out.println("PROCESS INFORMATION");
        System.out.println("===================");
        System.out.printf("Process id: %d%n", ph.pid());
        ProcessHandle.Info info = ph.info();
        System.out.printf("Command: %s%n", info.command().orElse(""));
        String[] args = info.arguments().orElse(new String[]{});
        System.out.println("Arguments:");
        for (String arg : args) {
            System.out.printf("   %s%n", arg);
        }
        System.out.printf("Command line: %s%n", info.commandLine().orElse(""));
        System.out.printf("Start time: %s%n",
                info.startInstant().orElse(Instant.now()).toString());
        System.out.printf("Run time duration: %sms%n",
                info.totalCpuDuration()
                        .orElse(Duration.ofMillis(0)).toMillis());
        System.out.printf("Owner: %s%n", info.user().orElse(""));
        System.out.println();
    }
}
