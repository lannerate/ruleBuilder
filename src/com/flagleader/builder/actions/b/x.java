package com.flagleader.builder.actions.b;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.actions.aq;
import com.flagleader.builder.actions.bl;
import com.flagleader.repository.db.CustomSql;
import com.flagleader.repository.excel.IExcelObject;
import com.flagleader.repository.rom.IBOAndContainer;
import com.flagleader.repository.rom.IBusinessObject;
import com.flagleader.repository.soap.SoapService;
import com.flagleader.repository.tree.ClassContainer;
import com.flagleader.repository.tree.CustomFunction;
import com.flagleader.repository.tree.IRulePackage;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.repository.tree.InterfaceContainer;
import com.flagleader.repository.xml.TreeValueNode;
import com.flagleader.repository.xml.XmlNode;

public class x extends bl
{
  public x(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  public void b(ITreeNode paramITreeNode)
  {
    if ((paramITreeNode != null) && (!paramITreeNode.isLocked()))
    {
      Object localObject;
      if ((paramITreeNode instanceof IBOAndContainer))
      {
        localObject = (IBOAndContainer)paramITreeNode;
        if (((IBOAndContainer)localObject).getMainPackage() != null)
          this.a.getMessageWindow().a(((IBOAndContainer)localObject).getMainPackage().getAllElementSelect((IBusinessObject)localObject));
      }
      else if ((paramITreeNode instanceof IExcelObject))
      {
        localObject = (IExcelObject)paramITreeNode;
        if (((IExcelObject)localObject).getMainPackage() != null)
          this.a.getMessageWindow().a(((IExcelObject)localObject).getMainPackage().getAllElementSelect((IBusinessObject)localObject));
      }
      else if ((paramITreeNode instanceof TreeValueNode))
      {
        localObject = (TreeValueNode)paramITreeNode;
        if (((TreeValueNode)localObject).getMainPackage() != null)
          this.a.getMessageWindow().a(((TreeValueNode)localObject).getMainPackage().getAllElementSelect((IBusinessObject)localObject));
      }
      else if ((paramITreeNode instanceof ClassContainer))
      {
        localObject = (ClassContainer)paramITreeNode;
        if (((ClassContainer)localObject).getMainPackage() != null)
          this.a.getMessageWindow().a(((ClassContainer)localObject).getMainPackage().getAllElementSelect((IBusinessObject)localObject));
      }
      else if ((paramITreeNode instanceof InterfaceContainer))
      {
        localObject = (InterfaceContainer)paramITreeNode;
        if (((InterfaceContainer)localObject).getMainPackage() != null)
          this.a.getMessageWindow().a(((InterfaceContainer)localObject).getMainPackage().getAllElementSelect((IBusinessObject)localObject));
      }
      else if ((paramITreeNode instanceof CustomFunction))
      {
        localObject = (CustomFunction)paramITreeNode;
        if (((CustomFunction)localObject).getMainPackage() != null)
          this.a.getMessageWindow().a(((CustomFunction)localObject).getMainPackage().getAllElementSelect(((CustomFunction)localObject).getFunctionMember()));
      }
      else if ((paramITreeNode instanceof CustomSql))
      {
        localObject = (CustomSql)paramITreeNode;
        if (((CustomSql)localObject).getMainPackage() != null)
          this.a.getMessageWindow().a(((CustomSql)localObject).getMainPackage().getAllElementSelect(((CustomSql)localObject).getExecuteFunction()));
      }
      else if ((paramITreeNode instanceof SoapService))
      {
        localObject = (SoapService)paramITreeNode;
        if (((SoapService)localObject).getMainPackage() != null)
          this.a.getMessageWindow().a(((SoapService)localObject).getMainPackage().getAllElementSelect((IBusinessObject)localObject));
      }
      else if ((paramITreeNode instanceof XmlNode))
      {
        localObject = (XmlNode)paramITreeNode;
        if (((XmlNode)localObject).getMainPackage() != null)
          this.a.getMessageWindow().a(((XmlNode)localObject).getMainPackage().getAllElementSelect((IBusinessObject)localObject));
      }
    }
  }

  public String a()
  {
    return "SearchDefines";
  }

  protected boolean c(ITreeNode paramITreeNode)
  {
    return true;
  }

  protected boolean d()
  {
    return true;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.b.x
 * JD-Core Version:    0.6.0
 */