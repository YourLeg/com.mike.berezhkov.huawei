/*
 * generated by Xtext 2.25.0
 */
package com.mike.berezhkov.huawei;


/**
 * Initialization support for running Xtext languages without Equinox extension registry.
 */
public class CPoCPStandaloneSetup extends CPoCPStandaloneSetupGenerated {

	public static void doSetup() {
		new CPoCPStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}
