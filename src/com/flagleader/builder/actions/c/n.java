package com.flagleader.builder.actions.c;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.dialogs.e.u;
import com.flagleader.repository.IElement;
import com.flagleader.repository.rlm.RuleToken;
import com.flagleader.repository.rlm.action.AssignJudgeToken;
import com.flagleader.repository.rlm.action.AssignToken;
import com.flagleader.repository.rlm.action.StatementContainerToken;
import com.flagleader.repository.rlm.action.XmlFunctionToken;
import com.flagleader.repository.rlm.lang.IMultiActionToken;
import com.flagleader.repository.rlm.lang.IValueContainerToken;
import com.flagleader.repository.rlm.value.FieldToken;
import com.flagleader.repository.rom.IBusinessObjectEditen;
import com.flagleader.repository.rom.IWhileObject;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.repository.tree.Rule;
import com.flagleader.repository.tree.ValueLibrary;
import com.flagleader.repository.tree.VariableLibrary;
import com.flagleader.repository.xml.XmlFunction;
import com.flagleader.repository.xml.XmlNode;
import java.util.List;

public class n extends r
{
  public n(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  public void b(ITreeNode paramITreeNode)
  {
    if ((paramITreeNode == null) || (paramITreeNode.isLocked()) || (!(paramITreeNode instanceof Rule)))
      return;
    Rule localRule = (Rule)paramITreeNode;
    localRule.getRuleElementToken().getThenActions();
    u localu = new u(this.a.getShell(), localRule.getEnvionment(), 1);
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
        Object localObject1 = localXmlNode.getXmlFunction("gettext");
        if (localObject1 == null)
          continue;
        StatementContainerToken localStatementContainerToken = new StatementContainerToken();
        localRule.getRuleElementToken().getThenActions().addChildElement(localStatementContainerToken, 0);
        Object localObject2 = new AssignToken();
        localStatementContainerToken.addChildElement((IElement)localObject2);
        FieldToken localFieldToken = new FieldToken();
        ((AssignToken)localObject2).addChildElement(localFieldToken);
        ((AssignToken)localObject2).addChildElement(new AssignJudgeToken());
        if (localIBusinessObjectEditen != null)
          localFieldToken.setMemberElement(localIBusinessObjectEditen);
        else
          ((AssignToken)localObject2).changeFieldType(((XmlFunction)localObject1).getJavaType());
        XmlFunctionToken localXmlFunctionToken = new XmlFunctionToken(((XmlFunction)localObject1).getValueType());
        ((AssignToken)localObject2).getComparedValue().addChildElement(localXmlFunctionToken);
        localXmlFunctionToken.setMemberElement((IElement)localObject1);
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
    return "LoadXmlNodeGet";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.c.n
 * JD-Core Version:    0.6.0
 */