package com.flagleader.builder.actions.c;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.dialogs.e.q;
import com.flagleader.repository.IElement;
import com.flagleader.repository.db.FieldModel;
import com.flagleader.repository.db.TableFunction;
import com.flagleader.repository.db.TableModel;
import com.flagleader.repository.rlm.RuleToken;
import com.flagleader.repository.rlm.action.StatementContainerToken;
import com.flagleader.repository.rlm.action.TableFunctionToken;
import com.flagleader.repository.rlm.condition.BooleanJudgeToken;
import com.flagleader.repository.rlm.condition.ConditionToken;
import com.flagleader.repository.rlm.lang.IMultiActionToken;
import com.flagleader.repository.rlm.lang.IMultiConditionToken;
import com.flagleader.repository.rlm.value.MemberToken;
import com.flagleader.repository.rlm.value.ValueToken;
import com.flagleader.repository.rom.IWhileObject;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.repository.tree.Rule;
import com.flagleader.repository.tree.ValueLibrary;
import com.flagleader.repository.tree.VariableLibrary;
import java.util.List;

public class g extends r
{
  public g(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  public void b(ITreeNode paramITreeNode)
  {
    if ((paramITreeNode == null) || (paramITreeNode.isLocked()) || (!(paramITreeNode instanceof Rule)))
      return;
    Rule localRule = (Rule)paramITreeNode;
    localRule.getRuleElementToken().getThenActions();
    q localq = new q(this.a.getShell(), localRule.getEnvionment(), 2);
    if (localq.open() == 0)
    {
      List localList = localq.a();
      TableModel localTableModel = null;
      Object localObject1;
      Object localObject2;
      Object localObject3;
      Object localObject4;
      TableFunctionToken localTableFunctionToken;
      ValueToken localValueToken;
      MemberToken localMemberToken;
      for (int i = localList.size() - 1; i >= 0; i--)
      {
        if (!(localList.get(i) instanceof FieldModel))
          continue;
        localObject1 = (FieldModel)localList.get(i);
        if ((((FieldModel)localObject1).getParent() != null) && ((((FieldModel)localObject1).getParent() instanceof TableModel)))
          localTableModel = (TableModel)((FieldModel)localObject1).getParent();
        localObject2 = localRule.getEnvionment().getValueLibrary().getNoCaseEditen(((FieldModel)localObject1).getFieldName(), ((FieldModel)localObject1).getDisplayName());
        if (localObject2 == null)
          localObject2 = localRule.getEnvionment().getTempVariableLibrary().getNoCaseEditen(((FieldModel)localObject1).getFieldName(), ((FieldModel)localObject1).getDisplayName());
        if ((localObject2 == null) && (localRule.hasSheetWhile()))
        {
          localObject3 = localRule.getAllWhileSheets();
          for (int j = 0; j < ((List)localObject3).size(); j++)
          {
            localObject4 = (IWhileObject)((List)localObject3).get(j);
            localObject2 = ((IWhileObject)localObject4).getNoCaseEditen(((FieldModel)localObject1).getValueName(), ((FieldModel)localObject1).getDisplayName());
            if (localObject2 != null)
              break;
          }
        }
        localObject3 = null;
        if ((((FieldModel)localObject1).getParent() != null) && ((((FieldModel)localObject1).getParent() instanceof TableModel)))
          localObject3 = ((TableModel)((FieldModel)localObject1).getParent()).getFieldSetFunc((FieldModel)localObject1);
        if (localObject3 == null)
          continue;
        localTableFunctionToken = new TableFunctionToken();
        localObject4 = new StatementContainerToken();
        localRule.getRuleElementToken().getThenActions().addChildElement((IElement)localObject4, 0);
        ((StatementContainerToken)localObject4).addChildElement(localTableFunctionToken);
        localTableFunctionToken.setMemberElement((IElement)localObject3);
        localValueToken = (ValueToken)localTableFunctionToken.getValueTokens().get(0);
        localMemberToken = new MemberToken(localValueToken.getValueType());
        localValueToken.addChildElement(localMemberToken);
        if (localObject2 != null)
          localMemberToken.setMemberElement((IElement)localObject2);
        localRule.setModified(true);
      }
      if (localTableModel != null)
      {
        TableFunction localTableFunction;
        if (localq.e())
        {
          localList = localTableModel.getPrimaryKeys();
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
            localTableFunctionToken = new TableFunctionToken();
            localObject4 = new StatementContainerToken();
            localRule.getRuleElementToken().getInitActions().addChildElement((IElement)localObject4);
            ((StatementContainerToken)localObject4).addChildElement(localTableFunctionToken);
            localTableFunctionToken.setMemberElement((IElement)localObject3);
            localValueToken = (ValueToken)localTableFunctionToken.getValueTokens().get(0);
            localMemberToken = new MemberToken(localValueToken.getValueType());
            localValueToken.addChildElement(localMemberToken);
            if (localObject2 != null)
              localMemberToken.setMemberElement((IElement)localObject2);
            localRule.setModified(true);
          }
          localTableFunction = localTableModel.getTableFunction("select");
          if (localTableFunction != null)
          {
            localObject1 = new TableFunctionToken();
            localObject2 = new StatementContainerToken();
            localRule.getRuleElementToken().getInitActions().addChildElement((IElement)localObject2);
            ((StatementContainerToken)localObject2).addChildElement((IElement)localObject1);
            ((TableFunctionToken)localObject1).setMemberElement(localTableFunction);
            localRule.setModified(true);
          }
          localTableFunction = localTableModel.getTableFunction("next");
          if (localTableFunction != null)
          {
            localObject1 = new ConditionToken();
            ((ConditionToken)localObject1).init();
            localRule.getRuleElementToken().getWhenCondition().addChildElement((IElement)localObject1);
            localObject2 = (MemberToken)((ConditionToken)localObject1).getFirstValue();
            ((MemberToken)localObject2).setMemberElement(localTableFunction);
            ((ConditionToken)localObject1).addChildElement(new BooleanJudgeToken());
          }
        }
        if ((localq.c()) && (localq.d()))
        {
          localTableFunction = localTableModel.getTableFunction("replace");
          if (localTableFunction != null)
          {
            localObject1 = new TableFunctionToken();
            localObject2 = new StatementContainerToken();
            localRule.getRuleElementToken().getThenActions().addChildElement((IElement)localObject2);
            ((StatementContainerToken)localObject2).addChildElement((IElement)localObject1);
            ((TableFunctionToken)localObject1).setMemberElement(localTableFunction);
            localRule.setModified(true);
          }
        }
        else if (localq.c())
        {
          localTableFunction = localTableModel.getTableFunction("insert");
          if (localTableFunction != null)
          {
            localObject1 = new TableFunctionToken();
            localObject2 = new StatementContainerToken();
            localRule.getRuleElementToken().getThenActions().addChildElement((IElement)localObject2);
            ((StatementContainerToken)localObject2).addChildElement((IElement)localObject1);
            ((TableFunctionToken)localObject1).setMemberElement(localTableFunction);
            localRule.setModified(true);
          }
        }
        else if (localq.d())
        {
          localTableFunction = localTableModel.getTableFunction("update");
          if (localTableFunction != null)
          {
            localObject1 = new TableFunctionToken();
            localObject2 = new StatementContainerToken();
            localRule.getRuleElementToken().getThenActions().addChildElement((IElement)localObject2);
            ((StatementContainerToken)localObject2).addChildElement((IElement)localObject1);
            ((TableFunctionToken)localObject1).setMemberElement(localTableFunction);
            localRule.setModified(true);
          }
        }
        else if (localq.b())
        {
          localTableFunction = localTableModel.getTableFunction("delete");
          if (localTableFunction != null)
          {
            localObject1 = new TableFunctionToken();
            localObject2 = new StatementContainerToken();
            localRule.getRuleElementToken().getThenActions().addChildElement((IElement)localObject2);
            ((StatementContainerToken)localObject2).addChildElement((IElement)localObject1);
            ((TableFunctionToken)localObject1).setMemberElement(localTableFunction);
            localRule.setModified(true);
          }
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
    return "LoadFieldsSet";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.c.g
 * JD-Core Version:    0.6.0
 */