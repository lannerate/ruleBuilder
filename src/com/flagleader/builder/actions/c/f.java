package com.flagleader.builder.actions.c;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.dialogs.e.q;
import com.flagleader.repository.IElement;
import com.flagleader.repository.db.FieldModel;
import com.flagleader.repository.db.ISelectObject;
import com.flagleader.repository.db.SelectTable;
import com.flagleader.repository.db.TableFunction;
import com.flagleader.repository.db.TableModel;
import com.flagleader.repository.rlm.RuleToken;
import com.flagleader.repository.rlm.action.AssignJudgeToken;
import com.flagleader.repository.rlm.action.AssignToken;
import com.flagleader.repository.rlm.action.StatementContainerToken;
import com.flagleader.repository.rlm.action.TableFunctionToken;
import com.flagleader.repository.rlm.condition.BooleanJudgeToken;
import com.flagleader.repository.rlm.condition.ConditionToken;
import com.flagleader.repository.rlm.lang.IMultiActionToken;
import com.flagleader.repository.rlm.lang.IMultiConditionToken;
import com.flagleader.repository.rlm.lang.IValueContainerToken;
import com.flagleader.repository.rlm.value.FieldToken;
import com.flagleader.repository.rlm.value.MemberToken;
import com.flagleader.repository.rlm.value.ValueToken;
import com.flagleader.repository.rom.IWhileObject;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.repository.tree.Rule;
import com.flagleader.repository.tree.ValueLibrary;
import com.flagleader.repository.tree.VariableLibrary;
import java.util.List;

public class f extends r
{
  public f(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  public void b(ITreeNode paramITreeNode)
  {
    if ((paramITreeNode == null) || (paramITreeNode.isLocked()) || (!(paramITreeNode instanceof Rule)))
      return;
    Rule localRule = (Rule)paramITreeNode;
    localRule.getRuleElementToken().getThenActions();
    q localq = new q(this.a.getShell(), localRule.getEnvionment(), 1);
    if (localq.open() == 0)
    {
      List localList = localq.a();
      ISelectObject localISelectObject = null;
      Object localObject1;
      Object localObject2;
      Object localObject3;
      Object localObject5;
      Object localObject4;
      Object localObject6;
      Object localObject7;
      for (int i = localList.size() - 1; i >= 0; i--)
      {
        if (!(localList.get(i) instanceof FieldModel))
          continue;
        localObject1 = (FieldModel)localList.get(i);
        if ((((FieldModel)localObject1).getParent() != null) && ((((FieldModel)localObject1).getParent() instanceof ISelectObject)))
          localISelectObject = (ISelectObject)((FieldModel)localObject1).getParent();
        localObject2 = localRule.getEnvionment().getValueLibrary().getNoCaseEditen(((FieldModel)localObject1).getFieldName(), ((FieldModel)localObject1).getDisplayName());
        if (localObject2 == null)
          localObject2 = localRule.getEnvionment().getTempVariableLibrary().getNoCaseEditen(((FieldModel)localObject1).getFieldName(), ((FieldModel)localObject1).getDisplayName());
        if ((localObject2 == null) && (localRule.hasSheetWhile()))
        {
          localObject3 = localRule.getAllWhileSheets();
          for (int j = 0; j < ((List)localObject3).size(); j++)
          {
            localObject5 = (IWhileObject)((List)localObject3).get(j);
            localObject2 = ((IWhileObject)localObject5).getNoCaseEditen(((FieldModel)localObject1).getValueName(), ((FieldModel)localObject1).getDisplayName());
            if (localObject2 != null)
              break;
          }
        }
        localObject3 = null;
        if ((((FieldModel)localObject1).getParent() != null) && ((((FieldModel)localObject1).getParent() instanceof ISelectObject)))
          localObject3 = ((ISelectObject)((FieldModel)localObject1).getParent()).getFieldGetFunc((FieldModel)localObject1);
        if (localObject3 == null)
          continue;
        localObject4 = new StatementContainerToken();
        localRule.getRuleElementToken().getThenActions().addChildElement((IElement)localObject4, 0);
        localObject5 = new AssignToken();
        ((StatementContainerToken)localObject4).addChildElement((IElement)localObject5);
        localObject6 = new FieldToken();
        ((AssignToken)localObject5).addChildElement((IElement)localObject6);
        ((AssignToken)localObject5).addChildElement(new AssignJudgeToken());
        if (localObject2 != null)
          ((FieldToken)localObject6).setMemberElement((IElement)localObject2);
        else
          ((AssignToken)localObject5).changeFieldType(((TableFunction)localObject3).getJavaType());
        localObject7 = new TableFunctionToken(((TableFunction)localObject3).getValueType());
        ((AssignToken)localObject5).getComparedValue().addChildElement((IElement)localObject7);
        ((TableFunctionToken)localObject7).setMemberElement((IElement)localObject3);
        localRule.setModified(true);
      }
      if ((localISelectObject != null) && (localq.e()))
      {
        localRule.setSupportInit(true);
        if ((localISelectObject instanceof TableModel))
        {
          localList = ((TableModel)localISelectObject).getPrimaryKeys();
          for (i = 0; i < localList.size(); i++)
          {
            localObject1 = (FieldModel)localList.get(i);
            localObject2 = localRule.getEnvionment().getValueLibrary().getNoCaseEditen(((FieldModel)localObject1).getFieldName(), ((FieldModel)localObject1).getDisplayName());
            if (localObject2 == null)
              localObject2 = localRule.getEnvionment().getTempVariableLibrary().getNoCaseEditen(((FieldModel)localObject1).getFieldName(), ((FieldModel)localObject1).getDisplayName());
            if ((localObject2 == null) && (localRule.isActiveSheetWhile()))
              localObject2 = localRule.getWhileSheet().getNoCaseEditen(((FieldModel)localObject1).getFieldName(), ((FieldModel)localObject1).getDisplayName());
            localObject3 = null;
            if ((((FieldModel)localObject1).getParent() != null) && ((((FieldModel)localObject1).getParent() instanceof TableModel)))
              localObject3 = ((TableModel)((FieldModel)localObject1).getParent()).getFieldSetFunc((FieldModel)localObject1);
            if (localObject3 == null)
              continue;
            localObject4 = new TableFunctionToken();
            localObject5 = new StatementContainerToken();
            localRule.getRuleElementToken().getInitActions().addChildElement((IElement)localObject5);
            ((StatementContainerToken)localObject5).addChildElement((IElement)localObject4);
            ((TableFunctionToken)localObject4).setMemberElement((IElement)localObject3);
            localObject6 = (ValueToken)((TableFunctionToken)localObject4).getValueTokens().get(0);
            localObject7 = new MemberToken(((ValueToken)localObject6).getValueType());
            ((ValueToken)localObject6).addChildElement((IElement)localObject7);
            if (localObject2 != null)
              ((MemberToken)localObject7).setMemberElement((IElement)localObject2);
            localRule.setModified(true);
          }
        }
        else if ((localISelectObject instanceof SelectTable))
        {
          localTableFunction = localISelectObject.getTableFunction("selectWhere");
          if (localTableFunction != null)
          {
            localObject1 = new TableFunctionToken();
            localObject2 = new StatementContainerToken();
            localRule.getRuleElementToken().getInitActions().addChildElement((IElement)localObject2);
            ((StatementContainerToken)localObject2).addChildElement((IElement)localObject1);
            ((TableFunctionToken)localObject1).setMemberElement(localTableFunction);
            localRule.setModified(true);
          }
        }
        TableFunction localTableFunction = localISelectObject.getTableFunction("select");
        if (localTableFunction != null)
        {
          localObject1 = new TableFunctionToken();
          localObject2 = new StatementContainerToken();
          localRule.getRuleElementToken().getInitActions().addChildElement((IElement)localObject2);
          ((StatementContainerToken)localObject2).addChildElement((IElement)localObject1);
          ((TableFunctionToken)localObject1).setMemberElement(localTableFunction);
          localRule.setModified(true);
        }
        localTableFunction = localISelectObject.getTableFunction("next");
        if (localTableFunction != null)
        {
          localObject1 = new ConditionToken();
          ((ConditionToken)localObject1).init();
          localRule.getRuleElementToken().getWhenCondition().addChildElement((IElement)localObject1);
          localObject2 = (MemberToken)((ConditionToken)localObject1).getFirstValue();
          ((MemberToken)localObject2).setMemberElement(localTableFunction);
          ((ConditionToken)localObject1).addChildElement(new BooleanJudgeToken());
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
    return "LoadFieldsGet";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.c.f
 * JD-Core Version:    0.6.0
 */