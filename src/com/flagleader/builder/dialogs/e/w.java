package com.flagleader.builder.dialogs.e;

import com.flagleader.builder.BuilderConfig;
import com.flagleader.builder.BuilderManager;
import com.flagleader.manager.builder.d;
import com.flagleader.manager.d.b;
import com.flagleader.manager.d.c;
import com.flagleader.repository.IElement;
import com.flagleader.repository.h;
import com.flagleader.repository.tree.IRuleRepository;
import com.flagleader.repository.tree.RuleProject;
import com.flagleader.repository.tree.RuleRepository;
import java.io.File;
import java.util.Iterator;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class w extends com.flagleader.builder.dialogs.r
{
  private boolean a = false;
  private Text b;
  private Text c;
  private Button d;
  private Button e;
  private BuilderManager f;

  public w(Shell paramShell, BuilderManager paramBuilderManager)
  {
    super(paramShell);
    this.f = paramBuilderManager;
  }

  public Control createDialogArea(Composite paramComposite)
  {
    setTitle(a("create_new_project"));
    Composite localComposite1 = (Composite)super.createDialogArea(paramComposite);
    localComposite1.setLayout(new GridLayout());
    Composite localComposite2 = new Composite(localComposite1, 0);
    c(localComposite2);
    Composite localComposite3 = new Composite(localComposite1, 0);
    d(localComposite3);
    Composite localComposite4 = new Composite(localComposite1, 0);
    e(localComposite4);
    b(localComposite1);
    return localComposite1;
  }

  private void c(Composite paramComposite)
  {
    paramComposite.setLayout(a(2));
    a(paramComposite).setText(a("project_name"));
    this.b = a(paramComposite, 2048, 350, 15);
  }

  private void d(Composite paramComposite)
  {
    paramComposite.setLayout(a(3));
    a(paramComposite).setText(a("path_road_save"));
    this.c = a(paramComposite, 2048, 300, 15);
    this.c.setText(BuilderConfig.getInstance().getProjPath());
    this.d = a(paramComposite, 8);
    this.d.setText(a("browse"));
    this.d.addSelectionListener(new x(this));
  }

  private void e(Composite paramComposite)
  {
    paramComposite.setLayout(a(1));
    this.e = a(paramComposite, 32);
    this.e.setText(a("overcast"));
    this.e.setSelection(this.a);
    this.e.addSelectionListener(new y(this));
  }

  private String a()
  {
    return this.b.getText();
  }

  private String b()
  {
    return this.c.getText();
  }

  protected void okPressed()
  {
    if ((this.b.getText().length() == 0) || (this.c.getText().length() == 0))
      return;
    BuilderConfig.getInstance().setProjPath(this.c.getText());
    if (this.f.isMainApplication())
      BuilderConfig.getInstance().save();
    RuleProject localRuleProject1 = RuleProject.createDefault(a());
    localRuleProject1.setDisplayName(a());
    String str = a() + File.separator + "default.prj";
    if (b().length() > 0)
      str = b() + File.separator + a() + File.separator + "default.prj";
    if ((this.f.getRulesManager().d() != null) && ((this.f.getRulesManager().d() instanceof RuleRepository)))
    {
      Iterator localIterator;
      if (this.a)
      {
        localIterator = this.f.getRulesManager().d().getChildrenIterator();
        while (localIterator.hasNext())
        {
          RuleProject localRuleProject2 = (RuleProject)localIterator.next();
          if (!localRuleProject2.getDisplayName().equals(a()))
            continue;
          localRuleProject2.dispose();
        }
      }
      else
      {
        localIterator = this.f.getRulesManager().d().getChildrenIterator();
        while (localIterator.hasNext())
        {
          if (!((IElement)localIterator.next()).getDisplayName().equals(a()))
            continue;
          this.f.showError(a("exist_same_project"));
          return;
        }
        if (new File(str).exists())
        {
          this.f.showError(a("exist_same_project"));
          return;
        }
      }
    }
    localRuleProject1.setFilePath(str);
    localRuleProject1.createDirectory();
    if ((this.f.getRulesManager().d() == null) || (!(this.f.getRulesManager().d() instanceof RuleRepository)))
    {
      this.f.getRulesManager().a(new RuleRepository(new File(RuleRepository.DEFAULTEXT)));
      b.a().a((RuleRepository)this.f.getRulesManager().d());
    }
    ((RuleRepository)this.f.getRulesManager().d()).addRuleProject(localRuleProject1);
    try
    {
      localRuleProject1.open();
      localRuleProject1.setModified(true);
      this.f.getUserLogger().c(c.a("HasLoadProject", new String[] { localRuleProject1.getFilePath() }));
    }
    catch (Exception localException)
    {
      this.f.getUserLogger().a(localException.getMessage(), localException);
    }
    this.f.getProjectTree().i();
    close();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.e.w
 * JD-Core Version:    0.6.0
 */