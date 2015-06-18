package com.ebao.aig.sg.fulfillment.rules.upload.processor;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ebao.aig.sg.fulfillment.rules.upload.mapping.convertor.FulfillmentRulesConvertor;
import com.ebao.aig.sg.fulfillment.rules.upload.parser.vo.FulfillmentModules;
import com.ebao.foundation.common.config.Env;

public class FulfillmentExecutor {

	private static final Log LOG = LogFactory.getLog(FulfillmentExecutor.class);
	
	public static void main(String args[]) throws Exception {

		String filePath = Env.getValue("CONFIGURATOR_FILE_PATH");
		
		FulfillmentModules modules = FulfillmentRulesProcessor.readRulesExcel(filePath);
		LOG.info("Fulfillment Excel Reading Process Completed");
		FulfillmentRulesConvertor.convertRules(modules);
		LOG.info("Fulfillment FieldVO to TargetVO Conversion Process Completed");
		

	}
}
