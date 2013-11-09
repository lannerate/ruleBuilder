package com.flagleader.builder.actions.c;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.dialogs.e.l;
import com.flagleader.repository.IElement;
import com.flagleader.repository.db.SheetFieldModel;
import com.flagleader.repository.db.SheetTable;
import com.flagleader.repository.db.TableFunction;
import com.flagleader.repository.rlm.RuleToken;
import com.flagleader.repository.rlm.action.AssignJudgeToken;
import com.flagleader.repository.rlm.action.AssignToken;
import com.flagleader.repository.rlm.action.StatementContainerToken;
import com.flagleader.repository.rlm.action.TableFunctionToken;
import com.flagleader.repository.rlm.lang.IMultiActionToken;
import com.flagleader.repository.rlm.lang.IValueContainerToken;
import com.flagleader.repository.rlm.value.FieldToken;
import com.flagleader.repository.rlm.value.MemberToken;
import com.flagleader.repository.rom.IWhileObject;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.repository.tree.Rule;
import com.flagleader.repository.tree.ValueLibrary;
import com.flagleader.repository.tree.VariableLibrary;
import java.util.List;

public class h extends r
{
  public h(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  public void b(ITreeNode paramITreeNode)
  {
    if ((paramITreeNode == null) || (paramITreeNode.isLocked()) || (!(paramITreeNode instanceof Rule)))
      return;
    Rule localRule = (Rule)paramITreeNode;
    localRule.getRuleElementToken().getThenActions();
    l locall = new l(this.a.getShell(), localRule.getEnvionment(), 1);
    if (locall.open() == 0)
    {
      List localList = locall.a();
      SheetTable localSheetTable = null;
      Object localObject1;
      Object localObject2;
      for (int i = localList.size() - 1; i >= 0; i--)
      {
        if (!(localList.get(i) instanceof SheetFieldModel))
          continue;
        localObject1 = (SheetFieldModel)localList.get(i);
        if ((((SheetFieldModel)localObject1).getParent() != null) && ((((SheetFieldModel)localObject1).getParent() instanceof SheetTable)))
          localSheetTable = (SheetTable)((SheetFieldModel)localObject1).getParent();
        localObject2 = localRule.getEnvionment().getValueLibrary().getNoCaseEditen(((SheetFieldModel)localObject1).getFieldName(), ((SheetFieldModel)localObject1).getDisplayName());
        if (localObject2 == null)
          localObject2 = localRule.getEnvionment().getTempVariableLibrary().getNoCaseEditen(((SheetFieldModel)localObject1).getFieldName(), ((SheetFieldModel)localObject1).getDisplayName());
        if ((localObject2 == null) && (localRule.isActiveSheetWhile()))
          localObject2 = localRule.getWhileSheet().getNoCaseEditen(((SheetFieldModel)localObject1).getFieldName(), ((SheetFieldModel)localObject1).getDisplayName());
        StatementContainerToken localStatementContainerToken = new StatementContainerToken();
        localRule.getRuleElementToken().getThenActions().addChildElement(localStatementContainerToken, 0);
        AssignToken localAssignToken = new AssignToken();
        localStatementContainerToken.addChildElement(localAssignToken);
        FieldToken localFieldToken = new FieldToken();
        localAssignToken.addChildElement(localFieldToken);
        localFieldToken.setMemberElement((IElement)localObject1);
        localAssignToken.addChildElement(new AssignJudgeToken());
        MemberToken localMemberToken = new MemberToken(((SheetFieldModel)localObject1).getValueType());
        localAssignToken.getComparedValue().addChildElement(localMemberToken);
        if (localObject2 != null)
          localMemberToken.setMemberElement((IElement)localObject2);
        localRule.setModified(true);
      }
      if ((localSheetTable != null) && (locall.c()))
      {
        TableFunction localTableFunction = localSheetTable.getTableFunction("insert");
        if (localTableFunction != null)
        {
          localObject1 = new TableFunctionToken();
          localObject2 = new StatementContainerToken();
          localRule.getRuleElementToken().getThenActions().addChildElement((IElement)localObject2, 0);
          ((StatementContainerToken)localObject2).addChildElement((IElement)localObject1);
          ((TableFunctionToken)localObject1).setMemberElement(localTableFunction);
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
    return "LoadSheetFields";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.c.h
 * JD-Core Version:    0.6.0
 */