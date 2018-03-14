package com.example.ldapurlstest;

import java.util.Arrays;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.ldap.core.support.LdapContextSource;

@SpringBootApplication
public class LdapUrlsTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(LdapUrlsTestApplication.class, args);
	}

	@Bean
	@ConfigurationProperties("something")
	public SampleStringArray sampleStringArray() {
		return new SampleStringArray();
	}

	@Bean
	public ApplicationRunner runner(SampleStringArray source) {
		return args ->  {
			System.out.println(Arrays.toString(source.getUrls()));
		};
	}

	public static class SampleStringArray {

		private String[] urls;

		public String[] getUrls() {
			return this.urls.clone();
		}

		public void setUrls(String[] urls) {
			this.urls = urls.clone();
		}

	}
}
