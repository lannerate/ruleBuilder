package com.flagleader.builder.actions.c;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.dialogs.e.l;
import com.flagleader.repository.db.ISelectObject;
import com.flagleader.repository.db.SheetFieldModel;
import com.flagleader.repository.rlm.RuleToken;
import com.flagleader.repository.rlm.action.AssignJudgeToken;
import com.flagleader.repository.rlm.action.AssignToken;
import com.flagleader.repository.rlm.action.StatementContainerToken;
import com.flagleader.repository.rlm.lang.IMultiActionToken;
import com.flagleader.repository.rlm.lang.IValueContainerToken;
import com.flagleader.repository.rlm.value.FieldToken;
import com.flagleader.repository.rlm.value.MemberToken;
import com.flagleader.repository.rom.IBusinessObjectEditen;
import com.flagleader.repository.rom.IWhileObject;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.repository.tree.Rule;
import com.flagleader.repository.tree.ValueLibrary;
import com.flagleader.repository.tree.VariableLibrary;
import java.util.List;

public class i extends r
{
  public i(BuilderManager paramBuilderManager)
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
      ISelectObject localISelectObject = null;
      for (int i = localList.size() - 1; i >= 0; i--)
      {
        if (!(localList.get(i) instanceof SheetFieldModel))
          continue;
        SheetFieldModel localSheetFieldModel = (SheetFieldModel)localList.get(i);
        if ((localSheetFieldModel.getParent() != null) && ((localSheetFieldModel.getParent() instanceof ISelectObject)))
          localISelectObject = (ISelectObject)localSheetFieldModel.getParent();
        IBusinessObjectEditen localIBusinessObjectEditen = localRule.getEnvionment().getValueLibrary().getNoCaseEditen(localSheetFieldModel.getFieldName(), localSheetFieldModel.getDisplayName());
        if (localIBusinessObjectEditen == null)
          localIBusinessObjectEditen = localRule.getEnvionment().getTempVariableLibrary().getNoCaseEditen(localSheetFieldModel.getFieldName(), localSheetFieldModel.getDisplayName());
        if ((localIBusinessObjectEditen == null) && (localRule.isActiveSheetWhile()))
          localIBusinessObjectEditen = localRule.getWhileSheet().getNoCaseEditen(localSheetFieldModel.getFieldName(), localSheetFieldModel.getDisplayName());
        if (localSheetFieldModel == null)
          continue;
        StatementContainerToken localStatementContainerToken = new StatementContainerToken();
        localRule.getRuleElementToken().getThenActions().addChildElement(localStatementContainerToken, 0);
        AssignToken localAssignToken = new AssignToken();
        localStatementContainerToken.addChildElement(localAssignToken);
        FieldToken localFieldToken = new FieldToken();
        localAssignToken.addChildElement(localFieldToken);
        localAssignToken.addChildElement(new AssignJudgeToken());
        if (localIBusinessObjectEditen != null)
          localFieldToken.setMemberElement(localIBusinessObjectEditen);
        else
          localAssignToken.changeFieldType(localSheetFieldModel.getJavaType());
        MemberToken localMemberToken = new MemberToken(localSheetFieldModel.getValueType());
        localAssignToken.getComparedValue().addChildElement(localMemberToken);
        if (localSheetFieldModel != null)
          localMemberToken.setMemberElement(localSheetFieldModel);
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
    return "LoadSheetFieldsGet";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.c.i
 * JD-Core Version:    0.6.0
 */