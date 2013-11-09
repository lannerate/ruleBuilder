package com.flagleader.builder.actions;

import com.flagleader.builder.BuilderManager;
import com.flagleader.repository.tree.IRuleRepository;
import com.flagleader.repository.tree.RuleProject;
import java.util.HashMap;
import java.util.List;
import org.eclipse.jface.action.Action;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Text;

public class ActionsManager
{
  private HashMap b;
  private BuilderManager c;
  public static final String CHECKACTIONID = "CheckItem";
  public static final String CONTACTUSACTION = "ContactUsItem";
  public static final String COPYACTION = "CopyItem";
  public static final String CREATEHTMLACTION = "CreateHtmlItem";
  public static final String CUTACTION = "CutItem";
  public static final String DELETEACTION = "DeleteItem";
  public static final String EDITWINDOWACTION = "EditWindowItem";
  public static final String EXPORTRUNPACKAGEACTION = "ExportRunPackage";
  public static final String EXPORTJAVACODEACTION = "ExportJavaCode";
  public static final String FINDACTION = "FindItem";
  public static final String MESSAGEWINDOWACTION = "MessageWindowItem";
  public static final String NEWRULEACTION = "NewRule";
  public static final String NEWRULEPACKAGEACTION = "NewRulePackage";
  public static final String PASTEACTION = "PasteItem";
  public static final String PRINTACTION = "PrintItem";
  public static final String PROJECTVIEWERACTION = "ProjectViewerItem";
  public static final String PROPERTIESACTION = "PropertiesItem";
  public static final String REDOACTION = "RedoItem";
  public static final String RENAMEACTION = "RenameItem";
  public static final String SAVEACTION = "SaveItem";
  public static final String SAVEASACTION = "SaveasItem";
  public static final String UNDOACTION = "UndoItem";
  public static final String UPDATESACTION = "UpdateItem";
  public static final String TESTACTION = "TestItem";
  public static final String ADDCLASSACTION = "AddClass";
  public static final String ADDCLASSFILEACTION = "AddClassFile";
  public static final String ADDFUNCTIONACTION = "AddFunction";
  public static final String NEWTESTLIBACTION = "NewTestLib";
  public static final String NEWTESTCASEACTION = "NewTestCase";
  Menu a;

  public ActionsManager(BuilderManager paramBuilderManager)
  {
    this.c = paramBuilderManager;
  }

  public HashMap getActionsMap()
  {
    if (this.b == null)
    {
      this.b = new HashMap();
      Action[] arrayOfAction = { new b(this, "AboutItem"), new i(this, "ContactUsItem"), new j(this, "CopyItem"), new k(this, "CutItem"), new m(this, "DeleteItem"), new n(this, "EditWindowItem"), new o(this, "ExitItem"), new K(this, "PropsWindowItem"), new p(this, "FindItem"), new q(this, "FindNextItem"), new s(this, "ImportProject"), new u(this, "MessageWindowItem"), new w(this, "NewProject"), new W(this, "SelectAllItem"), new y(this, "OpenItem"), new z(this, "PasteItem"), new I(this, "PrintItem"), new J(this, "ProjectViewerItem"), new R(this, "RedoItem"), new T(this, "SaveAllItem"), new U(this, "SaveasItem"), new V(this, "SaveRep"), new t(this, "LoadRep"), new X(this, "SetItem"), new A(this, "PreferencesItem"), new Y(this, "StatusbarItem"), new Z(this, "SubjectItem"), new ad(this, "ToolbarItem"), new af(this, "UndoItem"), new ag(this, "UpdateItem"), new ab(this, "TestItem"), new l(this, "dbManager"), new ai(this, "ruleServerItem"), new aa(this, "tagEditor"), new v(this, "MethodInfosEditor"), new r(this, "htmEditor"), new S(this, "rspEditor"), new g(this, "ClassInfoEditor"), new L(this, "ReCompileItem"), new M(this, "ReExportJspItem"), new f(this, "CheckProjectItem"), new ah(this, "UploadItem"), new d(this, "CheckInItem"), new e(this, "CheckOutItem"), new x(this, "NextItem"), new c(this, "BackItem") };
      for (int i = 0; i < arrayOfAction.length; i++)
      {
        String str = arrayOfAction[i].getId();
        this.b.put(str, arrayOfAction[i]);
      }
    }
    return this.b;
  }

  private boolean a()
  {
    Control localControl = Display.getCurrent().getFocusControl();
    if ((localControl != null) && (!localControl.isDisposed()))
    {
      if ((localControl instanceof Text))
        return true;
      if ((localControl instanceof StyledText))
        return true;
      if ((localControl instanceof Combo))
        return true;
    }
    return false;
  }

  private boolean b()
  {
    Control localControl = Display.getCurrent().getFocusControl();
    return (localControl != null) && (!localControl.isDisposed()) && ((localControl instanceof CCombo));
  }

  public Action getAction(String paramString)
  {
    Object localObject = null;
    if (getActionsMap() != null)
      if (getActionsMap().containsKey(paramString))
      {
        localObject = (Action)getActionsMap().get(paramString);
      }
      else
      {
        ak localak = this.c.getTreeNodeAction(paramString);
        if (localak != null)
        {
          localObject = new ae(this, paramString, localak);
          getActionsMap().put(paramString, localObject);
        }
      }
    return (Action)localObject;
  }

  public void updateRecentMenu()
  {
    if (this.a == null)
      return;
    Menu localMenu = this.a.getParentMenu();
    this.a.dispose();
    this.a = new Menu(localMenu);
    IRuleRepository localIRuleRepository = this.c.getRulesManager().d();
    if (localIRuleRepository != null)
    {
      List localList = localIRuleRepository.getClosedNode();
      if (localList.size() > 0)
        for (int i = 0; i < localList.size(); i++)
        {
          if (!(localList.get(i) instanceof RuleProject))
            continue;
          RuleProject localRuleProject = (RuleProject)localList.get(i);
          MenuItem localMenuItem = new MenuItem(this.a, 8);
          localMenuItem.setText(localRuleProject.getFilePath());
          localMenuItem.addListener(13, new a(this, localRuleProject));
        }
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.ActionsManager
 * JD-Core Version:    0.6.0
 */