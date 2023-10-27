<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <head>
                <title>Flower Information</title>
            </head>
            <body>
                <h1>Flower Information</h1>
                <table border="1">
                    <tr>
                        <th>Name</th>
                        <th>Soil</th>
                        <th>Origin</th>
                        <th>Stem Color</th>
                        <th>Leaf Color</th>
                        <th>Size</th>
                        <th>Temperature</th>
                        <th>Lighting</th>
                        <th>Watering</th>
                        <th>Multiplying</th>
                    </tr>
                    <tr>
                        <xsl:for-each select="flower/Plant">
                            <xsl:for-each select="Name|Soil|Origin|VisualParameters/StemColor|VisualParameters/LeafColor|VisualParameters/Size|GrowingTips/Temperature|GrowingTips/Lighting|GrowingTips/Watering|Multiplying">
                                <td>
                                    <xsl:value-of select="."/>
                                </td>
                            </xsl:for-each>
                        </xsl:for-each>
                    </tr>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
