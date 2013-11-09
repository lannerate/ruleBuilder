package com.flagleader.builder.actions;

import com.flagleader.builder.BuilderManager;
import com.flagleader.manager.r;
import com.flagleader.repository.tree.RuleRepository;
import java.io.File;
import org.eclipse.swt.widgets.FileDialog;

public class V extends h
{
  public V(ActionsManager paramActionsManager, String paramString)
  {
    super(paramActionsManager, paramString);
  }

  public void run()
  {
    if ((ActionsManager.a(this.a).getRulesManager().d() != null) && ((ActionsManager.a(this.a).getRulesManager().d() instanceof RuleRepository)))
    {
      RuleRepository localRuleRepository = (RuleRepository)ActionsManager.a(this.a).getRulesManager().d();
      FileDialog localFileDialog = new FileDialog(ActionsManager.a(this.a).getShell(), 8192);
      localFileDialog.setFilterExtensions(new String[] { "*.rep" });
      if (localRuleRepository.getRepFile() != null)
      {
        localFileDialog.setFilterPath(localRuleRepository.getRepFile().getParent());
        localFileDialog.setFileName(localRuleRepository.getRepFile().getName());
      }
      String str = localFileDialog.open();
      if ((str != null) && (str.length() > 0))
      {
        localRuleRepository.setRepFile(new File(str));
        localRuleRepository.setNeedSave(true);
      }
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.V
 * JD-Core Version:    0.6.0
 */