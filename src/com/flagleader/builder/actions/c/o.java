package com.flagleader.builder.actions.c;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.dialogs.e.u;
import com.flagleader.repository.IElement;
import com.flagleader.repository.rlm.RuleToken;
import com.flagleader.repository.rlm.action.StatementContainerToken;
import com.flagleader.repository.rlm.action.XmlFunctionToken;
import com.flagleader.repository.rlm.lang.IMultiActionToken;
import com.flagleader.repository.rlm.value.MemberToken;
import com.flagleader.repository.rlm.value.ValueToken;
import com.flagleader.repository.rom.IBusinessObjectEditen;
import com.flagleader.repository.rom.IWhileObject;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.repository.tree.Rule;
import com.flagleader.repository.tree.ValueLibrary;
import com.flagleader.repository.tree.VariableLibrary;
import com.flagleader.repository.xml.XmlNode;
import java.util.List;

public class o extends r
{
  public o(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  public void b(ITreeNode paramITreeNode)
  {
    if ((paramITreeNode == null) || (paramITreeNode.isLocked()) || (!(paramITreeNode instanceof Rule)))
      return;
    Rule localRule = (Rule)paramITreeNode;
    localRule.getRuleElementToken().getThenActions();
    u localu = new u(this.a.getShell(), localRule.getEnvionment(), 2);
    if (localu.open() == 0)
    {
      List localList = localu.a();
      for (int i = localList.size() - 1; i >= 0; i--)
      {
        if (!(localList.get(i) instanceof XmlNode))
          continue;
        XmlNode localXmlNode = (XmlNode)localList.get(i);
        IBusinessObjectEditen localIBusinessObjectEditen = localRule.getEnvionment().getValueLibrary().getNoCaseEditen(localXmlNode.getNodeName(), localXmlNode.getDisplayName());
        if (localIBusinessObjectEditen == null)
          localIBusinessObjectEditen = localRule.getEnvionment().getTempVariableLibrary().getNoCaseEditen(localXmlNode.getNodeName(), localXmlNode.getDisplayName());
        if ((localIBusinessObjectEditen == null) && (localRule.hasSheetWhile()))
        {
          localObject1 = localRule.getAllWhileSheets();
          for (int j = 0; j < ((List)localObject1).size(); j++)
          {
            localObject2 = (IWhileObject)((List)localObject1).get(j);
            localIBusinessObjectEditen = ((IWhileObject)localObject2).getNoCaseEditen(localXmlNode.getValueName(), localXmlNode.getDisplayName());
            if (localIBusinessObjectEditen != null)
              break;
          }
        }
        if ((localXmlNode.getMultiType() == 0) || (localXmlNode.getMultiType() == 2))
        {
          localObject1 = localXmlNode.getXmlFunction("init");
          if (localObject1 != null)
          {
            localXmlFunctionToken = new XmlFunctionToken();
            localObject2 = new StatementContainerToken();
            localRule.getRuleElementToken().getThenActions().addChildElement((IElement)localObject2, 0);
            ((StatementContainerToken)localObject2).addChildElement(localXmlFunctionToken);
            localXmlFunctionToken.setMemberElement((IElement)localObject1);
            localRule.setModified(true);
          }
        }
        Object localObject1 = localXmlNode.getXmlFunction("settext");
        if (localObject1 == null)
          continue;
        XmlFunctionToken localXmlFunctionToken = new XmlFunctionToken();
        Object localObject2 = new StatementContainerToken();
        localRule.getRuleElementToken().getThenActions().addChildElement((IElement)localObject2, 0);
        ((StatementContainerToken)localObject2).addChildElement(localXmlFunctionToken);
        localXmlFunctionToken.setMemberElement((IElement)localObject1);
        ValueToken localValueToken = (ValueToken)localXmlFunctionToken.getValueTokens().get(0);
        MemberToken localMemberToken = new MemberToken(localValueToken.getValueType());
        localValueToken.addChildElement(localMemberToken);
        if (localIBusinessObjectEditen != null)
          localMemberToken.setMemberElement(localIBusinessObjectEditen);
        localRule.setModified(true);
      }
      localRule.updateViewer();
    }
  }

  protected boolean c(ITreeNode paramITreeNode)
  {
    return paramITreeNode instanceof Rule;
  }

  public String a()
  {
    return "LoadXmlNodeSet";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.c.o
 * JD-Core Version:    0.6.0
 */