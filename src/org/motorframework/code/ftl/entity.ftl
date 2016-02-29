package ${code.packageName}
public class ${code.className} implements Serializable{
	private static final long serialVersionUID = 1L;
	/********** attribute ***********/
	<#list code.properties as property>
    private ${property.type} ${property.name};
	</#list>
	
	/********** constructors ***********/
	public ${code.className}() {
    }
    
    public ${code.className}(<#list code.properties as property>${property.type} ${property.name}<#if property_has_next>, </#if></#list>) {
    <#list code.properties as property>
        this.${property.name} = ${property.name};
    </#list>
    }
    
    /********** get/set ***********/
    <#list code.properties as property>
    public ${property.type} get${property.name?cap_first}() {
        return ${property.name};
    }
 
    public void set${property.name?cap_first}(${property.type} ${property.name}) {
        this.${property.name} = ${property.name};
    }
	</#list>
}