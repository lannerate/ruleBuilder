package com.flagleader.builder.actions.c;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.e.a.k;
import com.flagleader.repository.IElement;
import com.flagleader.repository.db.FieldModel;
import com.flagleader.repository.db.ISelectObject;
import com.flagleader.repository.db.TableFunction;
import com.flagleader.repository.db.TableModel;
import com.flagleader.repository.rlm.RuleToken;
import com.flagleader.repository.rlm.action.AssignJudgeToken;
import com.flagleader.repository.rlm.action.AssignToken;
import com.flagleader.repository.rlm.action.StatementContainerToken;
import com.flagleader.repository.rlm.action.TableFunctionToken;
import com.flagleader.repository.rlm.action.XmlFunctionToken;
import com.flagleader.repository.rlm.lang.IMultiActionToken;
import com.flagleader.repository.rlm.lang.IValueContainerToken;
import com.flagleader.repository.rlm.value.FieldToken;
import com.flagleader.repository.rlm.value.MemberToken;
import com.flagleader.repository.rlm.value.ValueToken;
import com.flagleader.repository.rom.IBusinessObjectEditen;
import com.flagleader.repository.rom.IVariableObject;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.repository.tree.Rule;
import com.flagleader.repository.xml.XmlFunction;
import com.flagleader.repository.xml.XmlNode;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import org.eclipse.jface.wizard.WizardDialog;

public class e extends r
{
  public e(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  public void b(ITreeNode paramITreeNode)
  {
    if ((paramITreeNode == null) || (paramITreeNode.isLocked()) || (!(paramITreeNode instanceof Rule)))
      return;
    Rule localRule = (Rule)paramITreeNode;
    localRule.getRuleElementToken().getThenActions();
    k localk = new k(localRule);
    WizardDialog localWizardDialog = new WizardDialog(this.a.getShell(), localk);
    if (localWizardDialog.open() == 0)
    {
      LinkedHashMap localLinkedHashMap = localk.e();
      Iterator localIterator = localLinkedHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject1 = localIterator.next();
        Object localObject2 = localLinkedHashMap.get(localObject1);
        IBusinessObjectEditen localIBusinessObjectEditen = null;
        if ((localObject2 instanceof IBusinessObjectEditen))
          localIBusinessObjectEditen = (IBusinessObjectEditen)localObject2;
        Object localObject3;
        Object localObject4;
        Object localObject5;
        Object localObject6;
        Object localObject7;
        Object localObject8;
        Object localObject9;
        Object localObject10;
        if ((localObject1 instanceof FieldModel))
        {
          localObject3 = (FieldModel)localObject1;
          localObject4 = null;
          if ((((FieldModel)localObject3).getParent() != null) && ((((FieldModel)localObject3).getParent() instanceof TableModel)))
            localObject4 = ((TableModel)((FieldModel)localObject3).getParent()).getFieldSetFunc((FieldModel)localObject3);
          if (localObject4 == null)
            continue;
          localObject5 = new TableFunctionToken();
          localObject6 = new StatementContainerToken();
          localRule.getRuleElementToken().getThenActions().addChildElement((IElement)localObject6);
          ((StatementContainerToken)localObject6).addChildElement((IElement)localObject5);
          ((TableFunctionToken)localObject5).setMemberElement((IElement)localObject4);
          localObject7 = (ValueToken)((TableFunctionToken)localObject5).getValueTokens().get(0);
          if (localIBusinessObjectEditen != null)
            if ((localIBusinessObjectEditen instanceof FieldModel))
            {
              localObject8 = (FieldModel)localIBusinessObjectEditen;
              localObject9 = null;
              if ((((FieldModel)localObject8).getParent() != null) && ((((FieldModel)localObject8).getParent() instanceof ISelectObject)))
                localObject9 = ((ISelectObject)((FieldModel)localObject8).getParent()).getFieldGetFunc((FieldModel)localObject8);
              localObject10 = new TableFunctionToken(((TableFunction)localObject9).getValueType());
              ((ValueToken)localObject7).addChildElement((IElement)localObject10);
              ((TableFunctionToken)localObject10).setMemberElement((IElement)localObject9);
            }
            else if ((localIBusinessObjectEditen instanceof XmlNode))
            {
              localObject8 = (XmlNode)localIBusinessObjectEditen;
              localObject9 = ((XmlNode)localObject8).getXmlFunction("gettext");
              localObject10 = new XmlFunctionToken(((XmlFunction)localObject9).getValueType());
              ((ValueToken)localObject7).addChildElement((IElement)localObject10);
              ((XmlFunctionToken)localObject10).setMemberElement((IElement)localObject9);
            }
            else
            {
              localObject8 = new MemberToken(((ValueToken)localObject7).getValueType());
              ((ValueToken)localObject7).addChildElement((IElement)localObject8);
              ((MemberToken)localObject8).setMemberElement(localIBusinessObjectEditen);
            }
          localRule.setModified(true);
        }
        else if ((localObject1 instanceof IVariableObject))
        {
          localObject3 = new StatementContainerToken();
          localRule.getRuleElementToken().getThenActions().addChildElement((IElement)localObject3);
          localObject4 = new AssignToken();
          ((StatementContainerToken)localObject3).addChildElement((IElement)localObject4);
          localObject5 = new FieldToken();
          ((AssignToken)localObject4).addChildElement((IElement)localObject5);
          ((FieldToken)localObject5).setMemberElement((IVariableObject)localObject1);
          ((AssignToken)localObject4).addChildElement(new AssignJudgeToken());
          if (localIBusinessObjectEditen != null)
            if ((localIBusinessObjectEditen instanceof FieldModel))
            {
              localObject6 = (FieldModel)localIBusinessObjectEditen;
              localObject7 = null;
              if ((((FieldModel)localObject6).getParent() != null) && ((((FieldModel)localObject6).getParent() instanceof ISelectObject)))
                localObject7 = ((ISelectObject)((FieldModel)localObject6).getParent()).getFieldGetFunc((FieldModel)localObject6);
              localObject8 = new TableFunctionToken(((TableFunction)localObject7).getValueType());
              ((AssignToken)localObject4).getComparedValue().addChildElement((IElement)localObject8);
              ((TableFunctionToken)localObject8).setMemberElement((IElement)localObject7);
            }
            else if ((localIBusinessObjectEditen instanceof XmlNode))
            {
              localObject6 = (XmlNode)localIBusinessObjectEditen;
              localObject7 = ((XmlNode)localObject6).getXmlFunction("gettext");
              localObject8 = new XmlFunctionToken(((XmlFunction)localObject7).getValueType());
              ((AssignToken)localObject4).getComparedValue().addChildElement((IElement)localObject8);
              ((XmlFunctionToken)localObject8).setMemberElement((IElement)localObject7);
            }
            else
            {
              localObject6 = new MemberToken(((IVariableObject)localObject1).getValueType());
              ((AssignToken)localObject4).getComparedValue().addChildElement((IElement)localObject6);
              ((MemberToken)localObject6).setMemberElement(localIBusinessObjectEditen);
            }
          localRule.setModified(true);
        }
        else
        {
          if (!(localObject1 instanceof XmlNode))
            continue;
          localObject3 = (XmlNode)localObject1;
          localObject4 = ((XmlNode)localObject3).getXmlFunction("settext");
          if (localObject4 == null)
            continue;
          localObject5 = new XmlFunctionToken();
          localObject6 = new StatementContainerToken();
          localRule.getRuleElementToken().getThenActions().addChildElement((IElement)localObject6);
          ((StatementContainerToken)localObject6).addChildElement((IElement)localObject5);
          ((XmlFunctionToken)localObject5).setMemberElement((IElement)localObject4);
          localObject7 = (ValueToken)((XmlFunctionToken)localObject5).getValueTokens().get(0);
          if (localIBusinessObjectEditen != null)
            if ((localIBusinessObjectEditen instanceof FieldModel))
            {
              localObject8 = (FieldModel)localIBusinessObjectEditen;
              localObject9 = null;
              if ((((FieldModel)localObject8).getParent() != null) && ((((FieldModel)localObject8).getParent() instanceof ISelectObject)))
                localObject9 = ((ISelectObject)((FieldModel)localObject8).getParent()).getFieldGetFunc((FieldModel)localObject8);
              localObject10 = new TableFunctionToken(((TableFunction)localObject9).getValueType());
              ((ValueToken)localObject7).addChildElement((IElement)localObject10);
              ((TableFunctionToken)localObject10).setMemberElement((IElement)localObject9);
            }
            else if ((localIBusinessObjectEditen instanceof XmlNode))
            {
              localObject8 = (XmlNode)localIBusinessObjectEditen;
              localObject9 = ((XmlNode)localObject8).getXmlFunction("gettext");
              localObject10 = new XmlFunctionToken(((XmlFunction)localObject9).getValueType());
              ((ValueToken)localObject7).addChildElement((IElement)localObject10);
              ((XmlFunctionToken)localObject10).setMemberElement((IElement)localObject9);
            }
            else
            {
              localObject8 = new MemberToken(((ValueToken)localObject7).getValueType());
              ((ValueToken)localObject7).addChildElement((IElement)localObject8);
              ((MemberToken)localObject8).setMemberElement(localIBusinessObjectEditen);
            }
          localRule.setModified(true);
        }
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
    return "LoadAssignVariables";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.c.e
 * JD-Core Version:    0.6.0
 */