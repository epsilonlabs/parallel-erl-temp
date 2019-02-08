/*********************************************************************
 * Copyright (c) 2018 The University of York.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.evl.distributed.flink;

import org.apache.flink.api.common.ExecutionConfig.GlobalJobParameters;
import org.apache.flink.api.common.functions.AbstractRichFunction;
import org.apache.flink.api.common.functions.RuntimeContext;
import org.apache.flink.api.java.utils.ParameterTool;
import org.apache.flink.configuration.Configuration;
import org.eclipse.epsilon.evl.distributed.EvlModuleDistributedSlave;
import org.eclipse.epsilon.evl.distributed.context.EvlContextDistributedSlave;
import org.eclipse.epsilon.evl.distributed.launch.DistributedRunner;

/**
 * Performs one-time setup on slave nodes. This mainly involves parsing the script,
 * loading models and putting variables into the FrameStack.
 * 
 * @author Sina Madani
 * @since 1.6
 */
public abstract class EvlFlinkRichFunction extends AbstractRichFunction {
	
	private static final long serialVersionUID = -9011432964023365634L;
	
	protected transient EvlModuleDistributedSlave localModule;
	protected transient DistributedRunner configContainer;
	
	public static Configuration getParameters(RuntimeContext context, Configuration additionalParameters) {
		GlobalJobParameters globalParameters = context.getExecutionConfig().getGlobalJobParameters();
		Configuration parameters = null;
		if (globalParameters instanceof Configuration) {
			parameters = (Configuration) globalParameters;
		}
		else if (globalParameters instanceof ParameterTool) {
			parameters = ((ParameterTool)globalParameters).getConfiguration();
		}
		
		if (parameters == null || parameters.toMap().isEmpty()) {
			parameters = additionalParameters;
		}
		
		return parameters;
	}
	
	@Override
	public void open(Configuration additionalParameters) throws Exception {
		
		configContainer = EvlContextDistributedSlave.parseJobParameters(
			getParameters(getRuntimeContext(), additionalParameters).toMap()
		);
		localModule = (EvlModuleDistributedSlave) configContainer.getModule();
		
		configContainer.preExecute();
		localModule.prepareExecution();
	}
	
	@Override
	public void close() throws Exception {
		localModule.postExecution();
		configContainer.postExecute();
	}
}