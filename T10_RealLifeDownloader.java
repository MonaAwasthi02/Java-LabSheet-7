/**
 * Advance Q10: real-life multithreading example - downloading files.
 *
 * Roles of each thread:
 *   - Downloader threads (3): each downloads one file independently and in parallel,
 *     so total time is about that of the slowest file, not the sum of all.
 *   - Processor thread (1): starts only after ALL downloads finish (main uses join()),
 *     then processes (e.g. scans/unzips) the downloaded files.
 *   - main thread: coordinator - creates and starts the threads, waits for them with join().
 */
class DownloadTask extends Thread {
    private final String fileName;
    private final int sizeMb;

    DownloadTask(String fileName, int sizeMb) {
        super("Downloader-" + fileName);
        this.fileName = fileName;
        this.sizeMb = sizeMb;
    }

    @Override
    public void run() {
        System.out.println("[" + getName() + "] started downloading " + fileName + " (" + sizeMb + " MB)");
        for (int percent = 25; percent <= 100; percent += 25) {
            try {
                Thread.sleep(sizeMb * 20L); // bigger file = longer time
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("[" + getName() + "] " + percent + "% done");
        }
        System.out.println("[" + getName() + "] FINISHED " + fileName);
    }
}

class ProcessorTask extends Thread {
    ProcessorTask() {
        super("Processor");
    }

    @Override
    public void run() {
        System.out.println("[" + getName() + "] processing all downloaded files...");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("[" + getName() + "] processing complete.");
    }
}

public class T10_RealLifeDownloader {
    public static void main(String[] args) throws InterruptedException {
        DownloadTask d1 = new DownloadTask("video.mp4", 40);
        DownloadTask d2 = new DownloadTask("notes.pdf", 10);
        DownloadTask d3 = new DownloadTask("song.mp3", 25);

        d1.start();
        d2.start();
        d3.start();

        d1.join();
        d2.join();
        d3.join();
        System.out.println("[main] All downloads finished.\n");

        ProcessorTask p = new ProcessorTask();
        p.start();
        p.join();
        System.out.println("[main] Program complete.");
    }
}
