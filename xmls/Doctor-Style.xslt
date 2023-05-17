<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="html" indent="yes" />

<xsl:template match="/">
   <html>
    <p><b><xsl:value-of select="//name" /></b></p>
   	<p><b>Contents: </b><xsl:value-of select="//content" /></p>
   	<p><b>Doctor:</b></p>
   	
   	<p><b>Name:  </b> <xsl:value-of select="Doctor/@name"/></p>
   	<p><b>Email:  </b> <xsl:value-of select="Doctor/email"/></p>
   	<p><b>Department:  </b> <xsl:value-of select="Doctor/department"/></p>
   
   
   
   </html>
</xsl:template>

</xsl:stylesheet>