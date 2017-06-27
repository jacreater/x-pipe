package com.ctrip.xpipe.spring;




import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author marsqing
 *
 *         May 26, 2016 6:34:49 PM
 */
public class AbstractController {
	
	protected Logger logger = LoggerFactory.getLogger(getClass());

	public static final String API_PREFIX = "/api";

	public static final String CLUSTER_NAME_PATH_VARIABLE = "{clusterName:.+}";
	public static final String SHARD_NAME_PATH_VARIABLE = "{shardName:.+}";

	public static final String CLUSTER_ID_PATH_VARIABLE = "{clusterId:.+}";
	public static final String SHARD_ID_PATH_VARIABLE = "{shardId:.+}";



}
