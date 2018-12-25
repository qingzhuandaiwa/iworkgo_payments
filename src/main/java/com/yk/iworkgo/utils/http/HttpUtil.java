package com.yk.iworkgo.utils.http;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Map;
import java.util.Map.Entry;


public class HttpUtil {

	private static Logger logger = LoggerFactory.getLogger(HttpUtil.class);

    // 默认10秒超时
    private static final int DEFAULT_TIMEOUT = 30000;

    /**
     * http请求工具类，返回数据以GBK编码进行读取
     * @param url
     * @param headers
     * @param body
     * @return
     */
    public static HttpResp requestGBK(String url, Map<String, String> headers, String body) {
        return httpRequest(url, "POST", headers, body, "GBK");
    }


    /**
     * http请求工具类，返回数据以UTF-8编码进行读取
     * @param url
     * @param headers
     * @param body
     * @return
     */
    public static HttpResp requestUTF(String url, Map<String, String> headers, String body) {
        return httpRequest(url, "POST", headers, body, "UTF-8");
    }

	public static HttpResp requestUTF(String url, Map<String, String> headers, Map<String, String> params) {

		String body = "";
		for (Entry<String, String> entry : params.entrySet()) {
			try {
//				body += entry.getKey() + "=" + entry.getValue() + "&";
				body += entry.getKey() + "=" + URLEncoder.encode(entry.getValue(), "UTF-8") + "&";
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
			}
		}
		if (body.length() > 1) {
			body = body.substring(0, body.length() - 1);
		}

		return httpRequest(url, "POST", headers, body, "UTF-8");
	}

	private static HttpResp httpRequest(String url, String method, Map<String, String> headers, String body, String decodeCoding) {

        logger.info("[HttpRequest] method=" + method + " url=" + url);

		HttpURLConnection connection = null;
		BufferedReader reader = null;
		StringBuffer result = new StringBuffer("");
		HttpResp resp = new HttpResp();
		try {
			URL postUrl = new URL(url);
			if("https".equalsIgnoreCase(postUrl.getProtocol())){
				SslUtils.ignoreSsl();
			}
			connection = (HttpURLConnection) postUrl.openConnection();
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setRequestMethod(method);
			connection.setUseCaches(false);
			connection.setInstanceFollowRedirects(true);
            connection.setConnectTimeout(DEFAULT_TIMEOUT);
            connection.setReadTimeout(DEFAULT_TIMEOUT);
			if(headers != null && headers.size() != 0) {
				for (Entry<String, String> entry : headers.entrySet()) {
					connection.addRequestProperty(entry.getKey(), entry.getValue());
				}
			}
			connection.connect();
			if(body != null && !body.equals("")) {
				OutputStream os=connection.getOutputStream(); 
		        try {
					os.write(body.getBytes("UTF-8"));
				} catch (Exception e) {
					logger.error(e.getMessage(), e);
				} finally {
					if(os != null) {
				        os.flush();   
				        os.close(); 
					}
				}
			}
			reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), decodeCoding));
			String line = "";
			while ((line = reader.readLine()) != null) {
				result.append(line);
			}
			
			resp.setResponseCode(connection.getResponseCode());
			resp.setBody(result.toString());
			resp.setHeaders(connection.getHeaderFields());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
            resp.setExceptionMsg(e.getMessage());
		} finally {
			try {
				if(reader != null) {
					reader.close();
				}
			} catch (IOException e) {
                logger.error(e.getMessage(), e);
			}
			if(connection != null) {
				connection.disconnect();
			}
		}

		return resp;
	 }

	static class SslUtils {
		static void trustAllHttpsCertificates() throws Exception {
			TrustManager[] trustAllCerts = new TrustManager[1];
			TrustManager tm = new miTM();
			trustAllCerts[0] = tm;
			SSLContext sc = SSLContext.getInstance("SSL");
			sc.init(null, trustAllCerts, null);
			HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
		}
		static class miTM implements TrustManager,X509TrustManager {
			public X509Certificate[] getAcceptedIssuers() {
				return null;
			}
			public boolean isServerTrusted(X509Certificate[] certs) {
				return true;
			}
			public boolean isClientTrusted(X509Certificate[] certs) {
				return true;
			}
			public void checkServerTrusted(X509Certificate[] certs, String authType)
					throws CertificateException {
				return;
			}
			public void checkClientTrusted(X509Certificate[] certs, String authType)
					throws CertificateException {
				return;
			}
		}
		/**
		 * 忽略HTTPS请求的SSL证书，必须在openConnection之前调用
		 * @throws Exception
		 */
		static void ignoreSsl() throws Exception{
			HostnameVerifier hv = new HostnameVerifier() {
				public boolean verify(String urlHostName, SSLSession session) {
					System.out.println("Warning: URL Host: " + urlHostName + " vs. " + session.getPeerHost());
					return true;
				}
			};
			trustAllHttpsCertificates();
			HttpsURLConnection.setDefaultHostnameVerifier(hv);
		}
	}
	
}


