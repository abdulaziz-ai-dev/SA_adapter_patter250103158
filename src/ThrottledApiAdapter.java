public class ThrottledApiAdapter implements IRateLimitedService {
    private ThirdPartyApiServer apiServer;
    private long lastInvocationTimestamp = 0;

    public ThrottledApiAdapter(ThirdPartyApiServer apiServer) {
        this.apiServer = apiServer;
    }

    public synchronized String getProtectedData() {
        long currentTime = System.currentTimeMillis();
        long timePassed = currentTime - lastInvocationTimestamp;

        if (timePassed < 200) {
            try {
                Thread.sleep(200 - timePassed);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        lastInvocationTimestamp = System.currentTimeMillis();
        return apiServer.fetchData();
    }
}