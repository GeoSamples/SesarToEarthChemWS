/**
 * 
 */
/**
* @author  Bai
* @version 1.0
* @since   2017-07-26
 *
 * this class is used for prefix namespace in package level.
 */


@XmlSchema(
	    namespace = "http://app.geosamples.org",
	    elementFormDefault = XmlNsForm.QUALIFIED,
	    xmlns = {
	        @XmlNs(prefix="sam2", namespaceURI="http://app.geosamples.org")
	    }
	)  

package com.sesar.model;

import javax.xml.bind.annotation.*;
