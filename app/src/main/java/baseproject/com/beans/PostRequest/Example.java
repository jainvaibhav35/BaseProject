
package baseproject.com.beans.PostRequest;

import java.util.HashMap;
import java.util.Map;

public class Example {

    private String status;
    private baseproject.com.beans.PostRequest.data data;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The status
     */
    public String getStatus() {
        return status;
    }

    /**
     * 
     * @param status
     *     The status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 
     * @return
     *     The data
     */
    public baseproject.com.beans.PostRequest.data getData() {
        return data;
    }

    /**
     * 
     * @param data
     *     The data
     */
    public void setData(baseproject.com.beans.PostRequest.data data) {
        this.data = data;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
